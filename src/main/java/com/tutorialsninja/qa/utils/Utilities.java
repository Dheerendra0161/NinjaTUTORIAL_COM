package com.tutorialsninja.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Utilities {
	public static String generateEmailTimeStamp() {
		Date date = new Date();
		String emailStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "dheeruvish1608" + emailStamp + "@gmail.com";
	}

//	public static Object[][] getTestDaraFromExcel() throws IOException {
//
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
//				+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\testData\\TutorialsNinjaTestData.xlsx");
//		Workbook wbookObj = WorkbookFactory.create(fis);
//		Sheet sheetName = wbookObj.getSheet("Login");
//		int totalRow = sheetName.getLastRowNum();
//		int totalCols = sheetName.getRow(0).getLastCellNum();
//		Object[][] testData = new Object[totalRow][totalCols];
//		for (int i = 1; i < totalRow; i++) {
//
//			Row row = sheetName.getRow(i);
//			for (int j = 0; j < totalCols; j++) {
//				Cell cols = row.getCell(j);
//				CellType cellType = cols.getCellType();
//				switch (cellType) {
//				case STRING:
//					
//					Object[i][j] = cols.getStringCellValue();
//
//				}
//			}
//}
//		System.out.println(Utilities.getTestDaraFromExcel());
//		wbookObj.close();
//		return testData;
//
////			Row rowObj = sheetObj.getRow(1);
////			Cell cellObj = rowObj.getCell(1);
////			cellObj.getStringCellValue();
////			wbookObj.close();
//	}

}
