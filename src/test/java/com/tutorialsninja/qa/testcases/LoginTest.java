package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.listeners.QAListeners;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {

	public WebDriver driver;

	LoginPage loginPage;

	QAListeners logs;

	public LoginTest() throws IOException {
		super();
//	Note:	To explicitly call the superclass constructor from the subclass constructor, we use super() keyword. 
//		super() can be used only inside the subclass constructor and must be the first statement.
	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.http.factory", "jdk-http-client"); // Just to launch chrome setting after updation
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		loginPage = homepage.navaigateToLoginPage();
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	@Test(priority = 1, groups = { "Smoke", "Sanity" })
	public void verifyLoginWithValidCresentials() {

		// We are using logs for reporting like Cucumber
		logs.printLog("Login with valid credential");
		loginPage.LoginEmailPasswordClickLogin(prop.getProperty("Email"), prop.getProperty("Password"));

		logs.printLog("Successfully verify dashboard");
		// steps

		logs.printLog("Navigate to register link");
		// steps

	}

	@Test(priority = -1, groups = { "Smoke", "Sanity" })
	public void Failed_verifyLoginWithValidCresentials() {
		logs.printLog("Login with valid credential");
		loginPage.LoginEmailPasswordClickLogin(prop.getProperty("Emai"), prop.getProperty("Password"));

		logs.printLog("Successfully verify dashboard");
		// steps

		logs.printLog("Navigate to register link");
		// steps

	}

	// if there is no priority than its default value is 0. It will run in
	// alphabetical order
	// Priority:(Negative(-ve)value>without priority(0)ie.Alphabatic
	// sequence>Positive(+ve) value
	
	

	@Test(priority = 2, groups = { "Sanity" })
	public void verifyLoginWithInvalidCredentials() {

		loginPage.LoginEmailPasswordClickLogin(Utilities.generateEmailTimeStamp(),
				dataProp.getProperty("invalidpassword"));
		Assert.assertTrue(loginPage.warningMessage());
	}

	
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		loginPage.LoginEmailPasswordClickLogin(Utilities.generateEmailTimeStamp(), prop.getProperty("Password"));

	}

	@Test(priority = 4)
	public void verifyLoginWith_ValidEmailAnd_InvalidPassword() {
		loginPage.LoginEmailPasswordClickLogin(prop.getProperty("Email"), dataProp.getProperty("invalidpassword"));

	}

	@Test(priority = 5, dataProvider = "excelData")
	public void verifyLoginWith_ValidEmailAnd_InvalidPassword1(String Email, String Password) throws IOException {
		loginPage.LoginEmailPasswordClickLogin(Email, Password);
	}

	@DataProvider(name = "excelData")
	public Object[][] test_Data() throws IOException {
		Object[][] Data = Utilities.getTestDataFromExcel("Login"); // It always return list of 2 Dimensional Array
		return Data;
	}

	@Test()
	public void SetterGetterMethods() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsernameInput("dheerendra0161@gmail.com");
		loginPage.setPasswordInput("Marikpur@1");
		loginPage.clickLoginButton();
	}

}
