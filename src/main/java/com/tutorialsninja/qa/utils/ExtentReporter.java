package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws IOException {
	ExtentReports extentReport=new ExtentReports();
	File file = new File(System.getProperty("user.dir")+"\\Screenshots\\ExtentReport\\ExtentReport.html");
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setReportName("TutorialNinja Test Automation");
	sparkReporter.config().setDocumentTitle("TutorialNinja Automation Report");
	sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
	
	extentReport.attachReporter(sparkReporter);
	
	Properties prop =new Properties();
	//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\config\\Config.properties");
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\Config.properties");
	prop.load(fis);
	
	extentReport.setSystemInfo("Application URL", 	prop.getProperty("url"));
	extentReport.setSystemInfo("Browser Name", prop.getProperty("browser"));
	extentReport.setSystemInfo("Operating System", prop.getProperty("os.name"));
	extentReport.setSystemInfo("User Name", prop.getProperty("user.name"));
	extentReport.setSystemInfo("Java Version", prop.getProperty("java.version"));
	
	return extentReport;
	}
}