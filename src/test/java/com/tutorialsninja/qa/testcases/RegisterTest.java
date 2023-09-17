package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	public WebDriver driver;
	RegisterPage registerpage;

	public RegisterTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
//		homepage.clickOnMyAccount();
//		registerpage = homepage.clickOnResister();
		registerpage = homepage.navigateToRegisterPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

	@Test(priority = 1)
	public void VerifyRegisteringAnAccountWith_MandatoryFields() {

		// registerpage=new RegisterPage(driver);

//2		registerpage.enterFirstNameField(dataProp.getProperty("firstName"));
//		registerpage.enterLastNameField(dataProp.getProperty("lastName"));
//		registerpage.enterEmailField(Utilities.generateEmailTimeStamp());
//		registerpage.enterTelephoneField(dataProp.getProperty("telePhone"));
//		registerpage.enterPasswordField(dataProp.getProperty("inputPass"));
//		registerpage.enterConfirmPasswordField(dataProp.getProperty("inputPass"));
//		registerpage.enterCheckBoxField();
//		registerpage.enterContinueField();

		registerpage.EnterAllNeccessaryElement(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				Utilities.generateEmailTimeStamp(), dataProp.getProperty("telePhone"),
				dataProp.getProperty("inputPass"), dataProp.getProperty("inputPass"));
		registerpage.enterContinueField();
		
//1		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys("Ji");
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys("9750040161");
//		driver.findElement(By.id("input-password")).sendKeys("Mar@54321");
//		driver.findElement(By.id("input-confirm")).sendKeys("Mar@54321");
//		driver.findElement(By.name("newsletter")).click();
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		String actualSuccesHeading = driver.findElement(By.id("//div[@class='col-sm-9']/h1")).getText();
//		System.out.println(actualSuccesHeading);
//		Assert.assertEquals(actualSuccesHeading, "Your Account Has Been Created!");

	}

	@Test(priority = 2)
	public void VerifyRegisteringAnAccountWith_AllFields() {

		// registerpage=new RegisterPage(driver);
		
//		registerpage.enterFirstNameField(dataProp.getProperty("firstName"));
//		registerpage.enterLastNameField(dataProp.getProperty("lastName"));
//		registerpage.enterEmailField(Utilities.generateEmailTimeStamp());
//		registerpage.enterTelephoneField(dataProp.getProperty("telePhone"));
//		registerpage.enterPasswordField(dataProp.getProperty("inputPass"));
//		registerpage.enterConfirmPasswordField(dataProp.getProperty("inputPass"));
//		registerpage.enterSubscribeRBField();
//		registerpage.enterCheckBoxField();
//		registerpage.enterContinueField();

		registerpage.EnterAllNeccessaryElement(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				Utilities.generateEmailTimeStamp(), dataProp.getProperty("telePhone"),
				dataProp.getProperty("inputPass"), dataProp.getProperty("inputPass"));
		registerpage.enterSubscribeRBField();
		registerpage.enterContinueField();
//		driver.findElement(By.id("input-firstname")).sendKeys(	dataProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(	dataProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telePhone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("inputPass"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("inputPass"));
//		driver.findElement(By.name("newsletter")).click();
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//
//		String actualSuccesHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
//		Assert.assertEquals(actualSuccesHeading, "Your Account Has Been Created!");

	}

	@Test(priority = 3)
	public void VerifyRegisteringAnAccountWith_ValidEmailAdress() {

		// registerpage=new RegisterPage(driver);
		
//		registerpage.enterFirstNameField(dataProp.getProperty("firstName"));
//		registerpage.enterLastNameField(dataProp.getProperty("lastName"));
//		registerpage.enterEmailField(prop.getProperty("Email"));
//		registerpage.enterTelephoneField(dataProp.getProperty("telePhone"));
//		registerpage.enterPasswordField(dataProp.getProperty("inputPass"));
//		registerpage.enterConfirmPasswordField(dataProp.getProperty("inputPass"));
//		registerpage.enterSubscribeRBField();
//		registerpage.enterCheckBoxField();
//		registerpage.enterContinueField();
		
		registerpage.EnterAllNeccessaryElement(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("Email"), dataProp.getProperty("telePhone"),
				dataProp.getProperty("inputPass"), dataProp.getProperty("inputPass"));
		registerpage.enterSubscribeRBField();
		registerpage.enterContinueField();
		

//		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("Email"));
//		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telePhone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("inputPass"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("inputPass"));
//		driver.findElement(By.name("newsletter")).click();
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();

//		String actualSuccesHeading = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
//				.getText();
//		System.out.println(actualSuccesHeading);
//		Assert.assertEquals(actualSuccesHeading, "Warning: E-Mail Address is already registered!");

	}

	@Test(priority = 4)
	public void VerifyRegisteringAnAccount_Without_FillingAnyDetails() throws IOException {

		// registerpage=new RegisterPage(driver);
		registerpage.enterContinueField();

		// driver.findElement(By.xpath("//input[@value='Continue']")).click();

//		String actualPrivacyPolicyWarning = driver
//				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
//		Assert.assertEquals(actualPrivacyPolicyWarning, "Warning: You must agree to the Privacy Policy!");

	}
}
