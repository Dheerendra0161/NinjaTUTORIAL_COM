package com.tutorialsninja.qa.testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int maxRetries = 3; // Maximum number of times to retry a failed test
	private int retryCount = 0; // Current retry count

	@Override
	public boolean retry(ITestResult result) {

		if (retryCount < maxRetries) {
			retryCount++;
			return true; // Retry the test
		}
		return false; // Do not retry the test
	}


}
