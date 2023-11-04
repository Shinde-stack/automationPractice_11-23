package utilityMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Parametrization {
	
	public static String sheetData (String sheetName,int rowNo,int cellNo) {
		
		//row count starts from 0
		//column count starts from 0
		
		String filePath= System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"seleniumData.xlsx";
		
		FileInputStream fileToRead = null;
//can create object of File class then no need of 1st try and catch box		
		
		try 
		{
			fileToRead = new FileInputStream (filePath);
		} 
		catch (FileNotFoundException e) 
		{
           System.out.println("file not found to read data...parametrization...catch 1.1");
			e.printStackTrace();
		}
		
		String sheetData=null;
		try 
		{
			 sheetData=WorkbookFactory.create(fileToRead).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		} 
		catch (EncryptedDocumentException e1) 
		{
	           System.out.println("EncryptedDocumentException...parametrization...catch box 1");
               e1.printStackTrace();
		}
		catch (IOException e2) 
		{
	           System.out.println("IOException...parametrization...catch box 2");
               e2.printStackTrace();
		}
		
		System.out.println("from parametrization class...sheet data is -"+sheetData);

		return sheetData;
		
		
	}
	
	public static void xssfSheetData (String sheetName) {
		
//row count starts from 0
//column count starts from 1
		
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		XSSFRow row;
		
		String filePath= System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"seleniumData.xlsx";

		try 
		{
			workbook= new XSSFWorkbook (filePath);
		} 
		catch (IOException e) 
		{
	           System.out.println("IOException to read data 2...parametrization...catch 1.1");
		      e.printStackTrace();
		}
		
		 sheet = workbook.getSheet(sheetName);
		
		 int lastRowNo = sheet.getLastRowNum();
		 
		 row= sheet.getRow(lastRowNo);
		 
		 int lastCellNo = row.getLastCellNum();

		 System.out.println("last row no -"+lastRowNo);
		 System.out.println("last cell no -"+lastCellNo);
		
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
