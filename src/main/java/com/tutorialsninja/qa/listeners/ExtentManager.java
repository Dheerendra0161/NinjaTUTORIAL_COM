package com.tutorialsninja.qa.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            createReport();
        }
        return extent;
    }

    private static void createReport() {
        File file = new File(System.getProperty("user.dir") + "\\Screenshots\\ExtentReport\\ExtentReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("TutorialNinja Test Automation");
        sparkReporter.config().setDocumentTitle("TutorialNinja Automation Report");
        sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");

        extent.attachReporter(sparkReporter);
    }
}
