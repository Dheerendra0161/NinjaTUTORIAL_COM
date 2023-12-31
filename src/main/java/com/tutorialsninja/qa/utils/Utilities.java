package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {

	public static String generateEmailTimeStamp() {
		Date date = new Date();
		String emailStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "dheeruvish1608" + emailStamp + "@gmail.com";

	}

	// @DataProvider(name = "excelData")
	public static Object[][] getTestDataFromExcel(String SheetName) throws IOException {

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
				testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}

		wbookObj.close();
		return testData;
	}

	public static String captureScreenShot(WebDriver driver, String testName) {

		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = (System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png");

		try {
			FileUtils.copyFile(srcScreenshot, new File(destinationPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationPath;
	}

	
	
	public static String captureScreenShotReport(WebDriver driver, String testName) {
		String srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		byte[] decodedScreenshot = Base64.getDecoder().decode(srcScreenshot);

		String destinationPath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";

		try {
			FileUtils.writeByteArrayToFile(new File(destinationPath), decodedScreenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destinationPath;
	}

	
	
	
}
