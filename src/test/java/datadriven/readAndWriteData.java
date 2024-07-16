package datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import utility.ExcellUtil;

public class readAndWriteData extends ExcellUtil{

	@Test
	public void getdata() throws Throwable
	{
		 FileInputStream fis = new FileInputStream("C:\\Users\\phani\\eclipse-workspace\\Selenium\\testdata\\accoutdetails2.xlsx");
		 XSSFWorkbook wb =  new XSSFWorkbook(fis);
		 XSSFSheet sheet= wb.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		 int cell = sheet.getRow(row).getLastCellNum();
		 
		 for(int i = 0; i<=row; i++)
		 {
			 XSSFRow currentrow = sheet.getRow(i);
			 
			 for(int j = 0; j<cell; j++)
			 {
				XSSFCell currentcell = currentrow.getCell(j);
				String value = currentcell.toString();
				System.out.println(value);
			 }
		 }
	}
	
	//@Test
	public void writedata() throws Throwable
	{
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\accountdetails2.xlsx");
		XSSFWorkbook wb2 = new XSSFWorkbook();
		XSSFSheet sheet1 = wb2.getSheet("Sheet1");
		sheet1.createRow(0).createCell(2).setCellValue("Companay");
		
		//for()
		{
			
		}
	}
	
	/*@Test
	public void getdata2() throws Throwable
	{
		ExcellUtil eu = new ExcellUtil();
		eu.getRowData("C:\\Users\\phani\\eclipse-workspace\\Selenium\\testdata\\accoutdetails2.xlsx", "Sheet1");
		eu.getCellData("C:\\Users\\phani\\eclipse-workspace\\Selenium\\testdata\\accoutdetails2.xlsx", "Sheet1", 0);
	}*/
	
	
}
