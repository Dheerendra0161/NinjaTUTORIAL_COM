package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement emailButtonField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement WarningMessage;
	
	
	

	
	// Make constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public boolean isElementDisplayAndEnabled(WebElement ele) {
		boolean status;
		try {
			status = ele.isDisplayed();
			status = ele.isEnabled();
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public boolean warningMessage() {
		return isElementDisplayAndEnabled(WarningMessage);
	}

	
	
	// Combined all the above three method into one

	public void LoginEmailPasswordClickLogin(String emailText, String password) {
		emailButtonField.sendKeys(emailText);
		passwordField.sendKeys(password);
		loginButton.click();
	}

	
	
	// Encapsulation In java selenium
	// Getter method to access the username input field
	public WebElement getUsernameInput() {
		return emailButtonField;
	}

	// Setter method to set text in the username input field
	public void setUsernameInput(String username) {
		emailButtonField.sendKeys(username);
	}

	// Getter method to access the password input field
	public WebElement getPasswordInput() {
		return passwordField;
	}

	// Setter method to set text in the password input field
	public void setPasswordInput(String password) {
		passwordField.sendKeys(password);
	}

	// Method to click the login button
	public void clickLoginButton() {
		loginButton.click();
	}
}
