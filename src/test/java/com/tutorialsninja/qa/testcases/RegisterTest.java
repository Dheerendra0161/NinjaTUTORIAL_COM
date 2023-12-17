package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	public WebDriver driver;
	RegisterPage registerpage;
	AccountSuccessPage accountSuccessPage;

	public RegisterTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		registerpage = homepage.navigateToRegisterPage();

		accountSuccessPage = new AccountSuccessPage(driver);

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	@Test(priority = 1)

	public void VerifyRegisteringAnAccountWith_MandatoryFields() {

		registerpage.EnterAllNeccessaryElement(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				Utilities.generateEmailTimeStamp(), dataProp.getProperty("telePhone"),
				dataProp.getProperty("inputPass"), dataProp.getProperty("inputPass"));
		registerpage.enterContinueField();
	}

	@Test(priority = 2, groups = { "Sanity" })
	public void VerifyRegisteringAnAccountWith_AllFields() {

		registerpage.EnterAllNeccessaryElement(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				Utilities.generateEmailTimeStamp(), dataProp.getProperty("telePhone"),
				dataProp.getProperty("inputPass"), dataProp.getProperty("inputPass"));
		registerpage.enterSubscribeRBField();
		registerpage.enterContinueField();

		Assert.assertEquals(accountSuccessPage.accountcreated(),
				"Congratulations! Your new account has been successfully created!");
	}

	@Test(priority = 3, groups = { "Smoke", "Sanity" })
	public void VerifyRegistration_alreadyExisting_ValidEmailAdress() {
		registerpage.EnterAllNeccessaryElement(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("Email"), dataProp.getProperty("telePhone"), dataProp.getProperty("inputPass"),
				dataProp.getProperty("inputPass"));
		registerpage.enterSubscribeRBField();
		registerpage.enterContinueField();
		String accountExist = registerpage.AccountAlreadyExist();
		System.out.println(accountExist);
		Assert.assertEquals(accountExist, "Warning: E-Mail Address is already registered!");

	}

	@Test(priority = 4)
	public void VerifyRegisteringAnAccount_Without_FillingAnyDetails() throws IOException {
		registerpage.enterContinueField();

	}
}
