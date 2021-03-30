package com.athma.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.athma.qa.base.TestBase;

public class TestUtils extends TestBase {
	static Workbook book;
	static Sheet sheet;

	public TestUtils() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long IMP_WAIT = 30;
	
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\339154\\eclipse-workspace\\AthmaTest\\src\\main\\java\\com\\athma\\qa\\testdata\\TestData.xlsx");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) { 
			e.printStackTrace();
			// TODO: handle exception
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 for(int i = 0;i<sheet.getLastRowNum();i++) {
			 for(int j = 0; j < sheet.getRow(0).getLastCellNum();j++) {
				 data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				 
			 } }				
		

		return data;
	}
	
	
}
