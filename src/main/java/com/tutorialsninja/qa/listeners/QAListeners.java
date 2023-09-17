package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;
import com.tutorialsninja.qa.utils.Utilities;


// if ITestlistener not able to import go to POM and change scope Testng to compile 
//To override selected method from ITestlisteners go to Source than to Override implementation
public class QAListeners implements ITestListener {
	ExtentReports extentReport ;
	ExtentTest extentTest;
	//String testName;
	
	@Override
	public void onStart(ITestContext context)  {
		
				try {
					extentReport = ExtentReporter.generateExtentReport();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
//		testName = result.getName();
//		extentTest = extentReport.createTest(testName);
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO,result.getName()+" Started executing");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//testName = result.getName();
		extentTest.log(Status.PASS, result.getName()+" Got succesfully executed");
		
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		//testName = result.getName();
		//extentTest = extentReport.createTest(testName);
		WebDriver driver = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		//String destinationPath = (System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
//		String destinationPath = (System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png");
//		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		
//		try {
//			FileUtils.copyFile(srcScreenshot, new File(destinationPath));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		String destinationPath= Utilities.captureScreenShot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(destinationPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL,result.getName()+" Got failed");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP,  result.getName()+" Got Skipped");
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
		//To open automatically screenshot
		String pathToExtentReport=System.getProperty("user.dir")+"\\Screenshots\\ExtentReport\\ExtentReport.html";
		File extentReport= new File(pathToExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
