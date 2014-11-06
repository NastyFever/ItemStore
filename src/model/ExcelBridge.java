package model;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class ExcelBridge {
	
    final static int FIRST_COLUMN = 0;
    final static int SECOND_COLUMN = 1;
    final static int THIRD_COLUMN = 2;
    
    private boolean endOfColumns = false;
    
    public Items items;
    public Users users;
	
	public ExcelBridge () throws BiffException{
		


	}
	
	
	public void run() {
		endOfColumns = false;
		try {
			buildItems();
			buildUser();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void buildItems() throws BiffException {
		items = new Items();
		
		
		  Workbook workbook;
		  try {
			workbook = Workbook.getWorkbook(new File("items.ods"));			
			Sheet sheet = workbook.getSheet(0);
			  
			for(int i=0; i< sheet.getColumn(FIRST_COLUMN).length; i++){
				Cell cell1 = sheet.getCell(FIRST_COLUMN, i);
				Cell cell2 = sheet.getCell(SECOND_COLUMN, i);
				Cell cell3 = sheet.getCell(THIRD_COLUMN, i);
				
				if(endOfColumns){
					continue;
				}
				
				Item item = new Item(new Integer(cell1.getContents()), (cell2.getContents()), 
						  new Integer(cell3.getContents()));
				items.addItem(item);
//			    System.out.println(item.print());
			}
			workbook.close();
			} catch (FileNotFoundException e) {
				System.out.println("Couldn't find file");
			}
			catch (java.lang.NumberFormatException e) {
				endOfColumns = true;
			}
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}

	private void buildUser() throws BiffException {
		users = new Users();
		
		
		  Workbook workbook;
		  try {
			workbook = Workbook.getWorkbook(new File("users.ods"));			
			Sheet sheet = workbook.getSheet(0);
			  
			for(int i=0; i< sheet.getColumn(FIRST_COLUMN).length; i++){
				Cell cell1 = sheet.getCell(FIRST_COLUMN, i);
				Cell cell2 = sheet.getCell(SECOND_COLUMN, i);
				Cell cell3 = sheet.getCell(THIRD_COLUMN, i);
				
				if(endOfColumns){
					continue;
				}
				
				User item = new User(new Integer(cell1.getContents()), (cell2.getContents()), 
						  new Integer(cell3.getContents()), i);
				users.addUser(item);
//			    System.out.println(item.print());
			}
			workbook.close();
			} catch (FileNotFoundException e) {
				System.out.println("Couldn't find file");
			}
			catch (java.lang.NumberFormatException e) {
				endOfColumns = true;
			}
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}

	
	/**
	 * Assumes that there exists a value User in User-file and that
	 * that value hasn't changed row.
	 * 
	 * Might be a good idea to add a checker to this method.
	 * 
	 * @param newDept
	 * @param user
	 * @return
	 */

	public boolean updateDept(int newDept, User user) {
		
		try{
			Workbook workbook;
			workbook = Workbook.getWorkbook(new File("users.ods"));
			
			WritableWorkbook copy = Workbook.createWorkbook(new File("temp.ods"), workbook);
			
			WritableSheet sheet1 = copy.getSheet(0); 
//			WritableCell cell = sheet1.getWritableCell(FIRST_COLUMN, user.getRow()); 
		
		
		
				

			Number number = new Number(THIRD_COLUMN, user.getRow(), newDept); 
			sheet1.addCell(number);
			
		
		
			copy.write(); 
			copy.close();
		
		
			workbook.close();
		
			workbook = Workbook.getWorkbook(new File("temp.ods"));
			
			copy = Workbook.createWorkbook(new File("users.ods"), workbook);
			
			copy.write(); 
			copy.close();

			workbook.close();
		
		
//	    WritableWorkbook wworkbook;
//	    try {
//			wworkbook = Workbook.createWorkbook(new File("users.ods"));
//			WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
//
//			
//			int rowID=-1;
//			for(int i=0; i< wsheet.getColumn(FIRST_COLUMN).length; i++){
//
//				Cell cell1 = wsheet.getCell(FIRST_COLUMN, i);
//				
//					
//				if(new Integer(cell1.getContents()) == user){
//					rowID = i;
//					continue;
//				} 
//			}
//
//			if (rowID==-1)
//				return false;
//
//			WritableCell cell = wsheet.getWritableCell(FIRST_COLUMN, rowID); 
//
//			
//			Number number = (Number) (cell);
//			number.setValue(newDept);
////			wsheet.addCell(number);
//			
////			wsheet.write();
//			wworkbook.write();
//			wworkbook.close();
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Sheet sheet = wworkbook.getSheet(0);

	
		return true;
	}
	      
	      
	      
	      

		
		
}
