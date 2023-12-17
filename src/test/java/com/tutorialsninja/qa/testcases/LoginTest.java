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
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {

	public WebDriver driver;

	LoginPage loginPage;
	AccountPage accountPage;

	// Listeners listener;

	public LoginTest() throws IOException {
		super();
//	Note:	To explicitly call the superclass constructor from the subclass constructor, we use super() keyword. 
//		super() can be used only inside the subclass constructor and must be the first statement.
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		loginPage = homepage.navaigateToLoginPage();
		accountPage=new AccountPage(driver);
		
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

	@Test(priority = 1, groups = { "Smoke", "Sanity" })
	public void verifyLoginWithValidCresentials() {

	
		loginPage.LoginEmailPasswordClickLogin(prop.getProperty("Email"), prop.getProperty("Password"));
		Assert.assertEquals(accountPage.EditAccount(), "Edit your account information", "Not landed on the Account Page");

		

	}

	@Test(priority = -1, groups = { "Smoke", "Sanity" })
	public void Failed_verifyLoginWithValidCresentials() {

		// listener.printLog("Login with valid credential");
		loginPage.LoginEmailPasswordClickLogin(prop.getProperty("Email"), prop.getProperty("Password"));
		// listener.printLog("Successfully verify dashboard");
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
		Assert.assertTrue(loginPage.warningMessage());
	}

	@Test(priority = 4)
	public void verifyLoginWith_ValidEmailAnd_InvalidPassword() {
		loginPage.LoginEmailPasswordClickLogin(prop.getProperty("Email"), dataProp.getProperty("invalidpassword"));
		Assert.assertTrue(loginPage.warningMessage());
	}

	@Test(priority = 5, dataProvider = "excelData")
	public void verifyLoginWith_ValidEmailAnd_InvalidPassword1(String Email, String Password) throws IOException {
		loginPage.LoginEmailPasswordClickLogin(Email, Password);
		Assert.assertTrue(loginPage.warningMessage());
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
