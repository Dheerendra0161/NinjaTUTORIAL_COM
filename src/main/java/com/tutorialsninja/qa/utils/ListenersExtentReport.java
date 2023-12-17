package com.tutorialsninja.qa.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersExtentReport implements ITestListener {

	ExtentReports extentReport;
	static ExtentTest extentTest;

	public static ExtentReports generateExtentReport() throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\Screenshots\\ExtentReport\\ExtentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialNinja Test Automation");
		sparkReporter.config().setDocumentTitle("TutorialNinja Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\Config.properties");
		Properties prop = new Properties();
		prop.load(fis);

		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", prop.getProperty("browser"));
		extentReport.setSystemInfo("Operating System", prop.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", prop.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", prop.getProperty("java.version"));
		return extentReport;
	}

	@Override
	public void onStart(ITestContext context) {
		try {
			extentReport = ExtentReporter.generateExtentReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReport.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getName() + " Got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());

		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		extentTest.addScreenCaptureFromBase64String(screenshot);
		extentTest.log(Status.FAIL, result.getName() + " Got failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + " Got Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();

		String pathToExtentReport = System.getProperty("user.dir") + "\\Screenshots\\ExtentReport\\ExtentReport.html";
		File extentReportFile = new File(pathToExtentReport);
		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public ExtentTest printLog(String log) {
		return extentTest.log(Status.INFO, log);
	}
}
