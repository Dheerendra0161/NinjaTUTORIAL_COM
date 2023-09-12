package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utils.Utilities;

public class Login extends Base {
	
	public Login() throws IOException{
		super();
//	Note:	To explicitly call the superclass constructor from the subclass constructor, we use super() keyword. 
//		super() can be used only inside the subclass constructor and must be the first statement.
	}
	
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyLoginWithValidCresentials() {
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("Email"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),
				"Edit Your Accout not displayed");

	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidpassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actualWarningMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actualWarningMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("Email"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidpassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actualWarningMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

	}

}
