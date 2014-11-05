package model;

import gui.BuyPanel;
import gui.MainFrame;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class MainClass {
    final static int FIRST_COLUMN = 0;
    final static int SECOND_COLUMN = 1;

    ExcelBridge eBridge;
    StateHandler stateHandler = new StateHandler();
    BuyHandler bh;

    
    static Item item;
    static User user;
    
    public MainClass(){
    	try {
			eBridge = new ExcelBridge();
			bh = new BuyHandler(eBridge);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) 
		      throws BiffException, IOException, WriteException
	   {
		   System.out.println("Starting testing");
		   final MainClass model = new MainClass();
		   final MainFrame mainFrame;
	       try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                MainFrame frame = new MainFrame(model);
	                frame.setVisible(true);
	                frame.setAlwaysOnTop(true);
	            }
	        });
		   
		   
		   
		   while(true) {
			   model.run();
		   }
		   
	   }
    
    private void run(){
	   Scanner user_input = new Scanner(System.in);
	   
	   String barCodeS = user_input.next();
	   int barCode = Integer.parseInt(barCodeS);
	   
		eBridge.run();
		for (Item item:	eBridge.items.items.values())
			System.out.println(item.print());
		for (User item:	eBridge.users.users.values())
			System.out.println(item.print());
	   
	   if(stateHandler.isInStateItemInput()) {
		   item = eBridge.items.getItem(barCode);
		   if(item!=null){
			   System.out.println("Lägger till " + item.print());
			   bh.setItem(item);
			   stateHandler.nextState();
		   } else {
			   System.out.println("Item: " + barCode + " does not exist");
		   }
		   
	   } else if (stateHandler.isInStateUserInput()){
		   user = eBridge.users.getUser(barCode);
		   if(user!=null){
			   System.out.println("Lägger till " + user.print() + "på" + user.print());
			   bh.setUser(user);
			   bh.doBuy();
			   stateHandler.nextState();
		   } else {
			   System.out.println("User: " + barCode + " does not exist");
		   }
	   }    	
    }
    
    public void setUpBuyHandler(BuyPanel bp){
    	bh.setBuyPanel(bp);
    }
   
   private static void testMethodReadSome() throws BiffException, IOException{
      Workbook workbook = Workbook.getWorkbook(new File("Test.ods"));
      Sheet sheet = workbook.getSheet(0);
	   
      for(int i=0; i< sheet.getColumn(FIRST_COLUMN).length; i++){
    	  String output = "Row: " + (i+1);
          Cell cell1 = sheet.getCell(FIRST_COLUMN, i);
          Cell cell2 = sheet.getCell(SECOND_COLUMN, i);
          
          output += cell1.getContents() + " " + cell2.getContents();
          
          System.out.println(output);		   
	  }
   
      workbook.close();
   }
   
   
   private void testMethodWriteColumns() throws BiffException, IOException, WriteException {
	      WritableWorkbook wworkbook;
	      wworkbook = Workbook.createWorkbook(new File("Test.ods"));
	      WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
	      
	      final int FIRST_COLUMN = 0;
	      final int SECOND_COLUMN =1;
	      char letter = 'A';
	      for(int i =0; i<26; i++) {
	    	  int row = i;
		      Label label = new Label(FIRST_COLUMN, row, "" + letter);
			      wsheet.addCell(label);
			      
			      Number number = new Number(SECOND_COLUMN, row, i+1);
			      wsheet.addCell(number);
		    	  letter++;
		      }
		      
		      
		      
		      
		      wworkbook.write();
		      wworkbook.close();
	   }
	   
	   
	   
}
