package com.tutorialsninja.qa.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
	private ExtentReports extent = ExtentManager.createInstance();
	private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext context) {
		// No specific action required on test start
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS,
				MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		test.get().log(Status.FAIL,
				MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());

		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		test.get().addScreenCaptureFromBase64String(screenshot);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

		// To open automatically screenshot
		String pathToExtentReport = System.getProperty("user.dir") + "\\Screenshots\\ExtentReport\\ExtentReport.html";
		File extentReport = new File(pathToExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
