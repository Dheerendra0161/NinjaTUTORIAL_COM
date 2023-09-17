package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	
	public WebDriver driver;
	
	LoginPage loginPage;
	
	public LoginTest() throws IOException {
		super();
//	Note:	To explicitly call the superclass constructor from the subclass constructor, we use super() keyword. 
//		super() can be used only inside the subclass constructor and must be the first statement.
	}


	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homepage= new HomePage(driver);
//		homepage.clickOnMyAccount();
//		loginPage = homepage.selectLoginOption();
		loginPage=homepage.navaigateToLoginPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	@Test(priority = 1)
	public void verifyLoginWithValidCresentials() {
		
		//loginPage=new LoginPage(driver);
		
//		loginPage.enterEmailAdress(prop.getProperty("Email"));
//		loginPage.enterPassword(prop.getProperty("Password"));
//		loginPage.clickAtLoginButton();
		
		loginPage.LoginEmailPasswordClickLogin(prop.getProperty("Email"), prop.getProperty("Password"));
		
		
//		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("Email"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("Password"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();

//		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),
//				"Edit Your Accout not displayed");

	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		//loginPage=new LoginPage(driver);
		
//		loginPage.enterEmailAdress(Utilities.generateEmailTimeStamp());
//		loginPage.enterPassword(dataProp.getProperty("invalidpassword"));
//		loginPage.clickAtLoginButton();
		
		loginPage.LoginEmailPasswordClickLogin(Utilities.generateEmailTimeStamp(), dataProp.getProperty("invalidpassword"));
		
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
//		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidpassword"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();

//		String actualWarningMessage = driver
//				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
//		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
//		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		
		//loginPage=new LoginPage(driver);
		
//		loginPage.enterEmailAdress(Utilities.generateEmailTimeStamp());
//		loginPage.enterPassword(prop.getProperty("Password"));
//		loginPage.clickAtLoginButton();
		
		loginPage.LoginEmailPasswordClickLogin(Utilities.generateEmailTimeStamp(),prop.getProperty("Password"));
				
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("Password"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();

//		String actualWarningMessage = driver
//				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
//		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
//		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

	}

	@Test(priority = 4)
	public void verifyLoginWith_ValidEmailAnd_InvalidPassword() {
		
		//LoginPage=new LoginPage(driver);
//2		loginPage.enterEmailAdress(prop.getProperty("Email"));
//		loginPage.enterPassword(dataProp.getProperty("invalidpassword"));
//		loginPage.clickAtLoginButton();
		
		
		loginPage.LoginEmailPasswordClickLogin(prop.getProperty("Email"), dataProp.getProperty("invalidpassword"));
		

//1		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("Email"));
//		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidpassword"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();

//		String actualWarningMessage = driver
//				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
//		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
//		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

	}

	@Test(priority=5,dataProvider = "excelData")
	public void verifyLoginWith_ValidEmailAnd_InvalidPassword1(String Email, String Password) throws IOException {
		//LoginPage=new LoginPage(driver);
//		loginPage.enterEmailAdress(Email);
//		loginPage.enterPassword(Password);
//		loginPage.clickAtLoginButton();
		
		loginPage.LoginEmailPasswordClickLogin(Email, Password);
		
		
//		driver.findElement(By.id("input-email")).sendKeys(Email);
//		driver.findElement(By.id("input-password")).sendKeys(Password);
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@DataProvider(name = "excelData")
	public Object[][] test_Data() throws IOException {
		Object[][] Data = Utilities.getTestDaraFromExcel("Login");
		return Data;
	}

}
