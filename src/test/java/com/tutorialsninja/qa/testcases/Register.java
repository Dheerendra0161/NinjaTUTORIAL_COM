package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utils.Utilities;

public class Register extends Base {

	public Register() throws IOException {
		super();
	}

	WebDriver driver;

	@BeforeTest
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

//	@Test(priority=1)
//	public void VerifyRegisteringAnAccountWithMandatoryFields() {
//		
//		driver.findElement(By.id("input-firstname")).sendKeys("Dheerendra");
//		driver.findElement(By.id("input-lastname")).sendKeys("Ji");
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys("9750040161");
//		driver.findElement(By.id("input-password")).sendKeys("987654321");
//		driver.findElement(By.id("input-confirm")).sendKeys("987654321");
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.name("newsletter")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		String actualSuccesHeading = driver.findElement(By.id("//div[@class='col-sm-9']/h1")).getText();
//		System.out.println(actualSuccesHeading);
//		Assert.assertEquals(actualSuccesHeading, "Your Account Has Been Created!");

//	}

	@Test(priority = 2)
	public void VerifyRegisteringAnAccountWithAllFields() {
		
	
		
		

		driver.findElement(By.id("input-firstname")).sendKeys(	dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(	dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telePhone"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("inputPass"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("inputPass"));
		driver.findElement(By.name("newsletter")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualSuccesHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualSuccesHeading, "Your Account Has Been Created!");

	}

	@Test(priority = 3)  
	public void VerifyRegisteringAnAccountWithEmailAdress() {

		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("Email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telePhone"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("inputPass"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("inputPass"));
		driver.findElement(By.name("newsletter")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

//		String actualSuccesHeading = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
//				.getText();
//		System.out.println(actualSuccesHeading);
//		Assert.assertEquals(actualSuccesHeading, "Warning: E-Mail Address is already registered!");

	}

	@Test(priority = 4)
	public void VerifyRegisteringAnAccountWithoutFillingAnyDetails() throws IOException {
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
//		String actualPrivacyPolicyWarning = driver
//				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
//		Assert.assertEquals(actualPrivacyPolicyWarning, "Warning: You must agree to the Privacy Policy!");

	}
}
