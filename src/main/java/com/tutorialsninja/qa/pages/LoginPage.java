package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement emailButtonField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-email")
	private WebElement loginButton;
	
	
	// Make constructor 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	public void enterEmailAdress(String emailText) {
//		emailButtonField.sendKeys(emailText);
//	}
//	
//	public void enterPassword(String password) {
//		passwordField.sendKeys(password);
//	}
	
//	public void clickAtLoginButton() {
//		loginButton.click();
//	}
	
	
	
	//Combined all the  above three method into one
	
	public void LoginEmailPasswordClickLogin(String emailText,String password) {
		emailButtonField.sendKeys(emailText);
		passwordField.sendKeys(password);
		loginButton.click();
	}
		
}
