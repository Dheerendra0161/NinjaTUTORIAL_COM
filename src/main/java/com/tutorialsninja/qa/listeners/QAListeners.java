package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

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
	static ExtentTest extentTest;
	
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
		extentTest = extentReport.createTest(result.getName());
		//extentTest.log(Status.INFO,result.getName()+" Started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//extentTest.log(Status.PASS, result.getName()+" Got succesfully executed");
		
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		String destinationPath= Utilities.captureScreenShot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(destinationPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL,result.getName()+" Got failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
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
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	//@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }
	
	public QAListeners printLog(String log) {
		extentTest.log(Status.INFO, log);
		return new QAListeners();
	}
}
