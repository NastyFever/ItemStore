package model;

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

    public enum State {ITEM_INPUT, USER_INPUT};
    
    static State state = State.ITEM_INPUT;
    
    static Item item;
    
    public static void main(String[] args) 
		      throws BiffException, IOException, WriteException
	   {
		   System.out.println("Starting testing");
	
		   ExcelBridge eBridge = new ExcelBridge("");
		   
		   
		   while(true) {
			   Scanner user_input = new Scanner(System.in);
			   
			   String barCodeS = user_input.next();
			   int barCode = Integer.parseInt(barCodeS);
			   
			   if(state.equals(State.ITEM_INPUT)) {
				   item = eBridge.items.getItem(barCode);
				   if(item!=null){
					   System.out.println("HA! Vill du köpa en " + item.print());
					   state = State.USER_INPUT;
				   }
			   }
		   }
		   
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
