package model;

import java.io.File;
import java.io.IOException;

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
   public static void main(String[] args) 
		      throws BiffException, IOException, WriteException
	   {
//	      WritableWorkbook wworkbook;
//	      wworkbook = Workbook.createWorkbook(new File("Test.ods"));
//	      WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
//	      
//
//	      char letter = 'A';
//	      for(int i =0; i<26; i++) {
//	    	  int row = i;
//		      Label label = new Label(FIRST_COLUMN, row, "" + letter);
//		      wsheet.addCell(label);
//		      
//		      Number number = new Number(SECOND_COLUMN, row, i+1);
//		      wsheet.addCell(number);
//	    	  letter++;
//	      }
//	     ne
//	      
//	      
//	      
//	      wworkbook.write();
//	      wworkbook.close();
	   new ExcelBridge("");
//	   testMethodReadSome();
	   
//		      Workbook workbook = Workbook.getWorkbook(new File("Test.ods"));
//		      Sheet sheet = workbook.getSheet(0);
//		      Cell cell1 = sheet.getCell(0, 2);
//		      System.out.println(cell1.getContents());
//		      Cell cell2 = sheet.getCell(3, 4);
//		      System.out.println(cell2.getContents());
//		      workbook.close();
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
