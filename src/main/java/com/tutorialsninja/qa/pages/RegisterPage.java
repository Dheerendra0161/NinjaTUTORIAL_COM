package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement eneterFirstname;
	
	@FindBy(id="input-lastname")
	private WebElement eneterLastname;
	
	@FindBy(id="input-email")
	private WebElement eneterEmailID;
	
	@FindBy(id="input-telephone")
	private WebElement eneterTelephoneNo;
	
	@FindBy(id="input-password")
	private WebElement eneterPasswordNo;
	
	@FindBy(id="input-confirm")
	private WebElement eneterConfirmPasswordNo;
	
	@FindBy(name="newsletter")
	private WebElement SubscribeRadioButton;
	
	@FindBy(name="agree")
	private WebElement checkBoxButton;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	
//	public void enterFirstNameField(String firstname) {
//		eneterFirstname.sendKeys(firstname);
//	}
//	
//	public void enterLastNameField(String lastname) {
//		eneterLastname.sendKeys(lastname);
//	}
//	
//	public void enterEmailField(String emailId) {
//		eneterEmailID.sendKeys(emailId);
//	}
//	
//	public void enterTelephoneField(String Telephone) {
//		eneterTelephoneNo.sendKeys(Telephone);
//	}
//	
//	public void enterPasswordField(String password) {
//		eneterPasswordNo.sendKeys(password);
//	}
//	
//	public void enterConfirmPasswordField(String ConPassword) {
//		eneterConfirmPasswordNo.sendKeys(ConPassword);
//	}

	public void enterSubscribeRBField() {
		SubscribeRadioButton.click();
	}
	
//	public void enterCheckBoxField() {
//		checkBoxButton.click();
//	}
	
	public void enterContinueField() {
		continueButton.click();
	}

	
	public void EnterAllNeccessaryElement(String firstname,String lastname,String emailId,String Telephone,String password,String ConPassword) {
		
		eneterFirstname.sendKeys(firstname);
		eneterLastname.sendKeys(lastname);
		eneterEmailID.sendKeys(emailId);
		eneterTelephoneNo.sendKeys(Telephone);
		eneterPasswordNo.sendKeys(password);
		eneterConfirmPasswordNo.sendKeys(ConPassword);
		checkBoxButton.click();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
