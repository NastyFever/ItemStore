package model;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ExcelBridge {
	
    final static int FIRST_COLUMN = 0;
    final static int SECOND_COLUMN = 1;
    final static int THIRD_COLUMN = 2;
    
    private boolean endOfColumns = false;
    
    public Items items;
    public Users users;
	
	public ExcelBridge () throws BiffException{
		


	}
	
	
	public void run() throws BiffException {
		buildItems();
		buildUser();
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
			    System.out.println(item.print());
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
						  new Integer(cell3.getContents()));
				users.addUser(item);
			    System.out.println(item.print());
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


}
