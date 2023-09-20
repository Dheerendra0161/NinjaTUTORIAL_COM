package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//PageObjectModel Design Pattern
public class HomePage {
	WebDriver driver;
	
	//WebElements are objects
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccoutDropDown;

	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(xpath="//*[contains(text(),'Register')]")
	private WebElement resisterOption;
	
	//creating a constructor of HomePage
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//or PageFactory.initElements(driver, HomePage.class);

	}
	
	//Now we will Create Actions to performs operations
	
//	public void clickOnMyAccount() {
//		myAccoutDropDown.click();
//	}
	
	
	//My Account Method and LoginOption method  Combined to one method 
	public LoginPage navaigateToLoginPage() {
		myAccoutDropDown.click();
		loginOption.click();
		return new LoginPage(driver);    //return used here to navigate to Login.
	}
	
	
//	public LoginPage selectLoginOption() {
//		loginOption.click();
//		return new LoginPage(driver);
//	}
	
	
//	public RegisterPage clickOnResister() {
//		resisterOption.click();
//		return new RegisterPage(driver);
//		
//	}
	
	public RegisterPage navigateToRegisterPage() {
		myAccoutDropDown.click();
		resisterOption.click();
		return new RegisterPage(driver);   //return used  here to navigate to Register.
		
	}
	
}
