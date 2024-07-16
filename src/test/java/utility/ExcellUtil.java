package utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class ExcellUtil {

	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow rw;
	public static XSSFCell cl;
	public static XSSFCellStyle cs;
	
	public static String  getRowData(String excellFile, String excelSheet,int row,int cell) throws Throwable
	{
		fis = new FileInputStream(excellFile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(excelSheet);
		rw = sh.getRow(row);
		cl = rw.getCell(cell);
		String value = cl.getStringCellValue();
		return value;
	}
	
	public static int getRowCount(String excellFile, String ExcellSheet) throws Throwable
	{
		fis = new FileInputStream(excellFile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(ExcellSheet);
		int  value = sh.getLastRowNum();
		return value;
		
	}
	
	public static String getCellData(String excellFile, String excellSheet, int row,int cell) throws Throwable
	{
		fis = new FileInputStream(excellFile); 
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(excellSheet);
		rw = sh.getRow(row);
		cl = rw.getCell(cell);
		String value = cl.getStringCellValue();
		return value;
	}
	
	public static int getCellCount(String excellFile, String excellSheet, int row,int cell) throws Throwable
	{
		fis = new FileInputStream(excellFile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(excellSheet);
		rw = sh.getRow(row);
		int value = rw.getLastCellNum();
		return value;
	}
	
	
}
