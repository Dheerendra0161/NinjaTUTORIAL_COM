package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;


public class Utilities{

	public static String generateEmailTimeStamp() {
		Date date = new Date();
		String emailStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "dheeruvish1608"+emailStamp+"@gmail.com";
	}

	@DataProvider(name = "excelData")
	public static Object[][] getTestDaraFromExcel(String SheetName) throws IOException {

		
		    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
		            + "\\src\\main\\java\\com\\tutorialsninja\\qa\\testData\\TutorialsNinjaTestData.xlsx");
		    Workbook wbookObj = WorkbookFactory.create(fis);
		    Sheet sheetName = wbookObj.getSheet(SheetName);

		    int totalRows = sheetName.getLastRowNum() + 1;
		    int totalCols = sheetName.getRow(0).getLastCellNum();

		    DataFormatter format = new DataFormatter();
		    Object[][] testData = new Object[totalRows][totalCols];

		    for (int i = 1; i < totalRows; i++) {
		        for (int j = 0; j < totalCols; j++) {
		            testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
		        }
		    }

		    wbookObj.close();
		    return testData;
		}
	
		
//	@DataProvider(name = "excelData")
//	public static Object[][] getTestDaraFromExcel1(String SheetName) throws IOException {
//
//		
//		    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
//		            + "\\src\\main\\java\\com\\tutorialsninja\\qa\\testData\\TutorialsNinjaTestData.xlsx");
//		    Workbook wbookObj = WorkbookFactory.create(fis);
//		    Sheet sheetName = wbookObj.getSheet(SheetName);
//
//		    Iterator<Row> rowIterator = sheetName.iterator();
//		    while (rowIterator.hasNext()) {
//		        Row row = rowIterator.next();
//		        Iterator<Cell> cellIterator = row.iterator();
//		        while (cellIterator.hasNext()) {
//		            Cell cell = cellIterator.next();
//		            // Process the cell value
//		        }
//		    }
//		    DataFormatter dataFormatter =  dataFormatter.formatCellValue(cell);
//		   
//		    wbookObj.close();
//		    return testData;
//		}
	
	public static String captureScreenShot(WebDriver driver,String testName) {

		//String destinationPath = (System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = (System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
		
		try {
			FileUtils.copyFile(srcScreenshot, new File(destinationPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationPath;
	}
			
	}


