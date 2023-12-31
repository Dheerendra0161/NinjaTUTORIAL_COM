package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	WebDriver driver;
	@FindBy(xpath = "//p[text()='Congratulations! Your new account has been successfully created!']")
	WebElement accountSuccess;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String accountcreated() {
		return accountSuccess.getText();
	}
	
	

}
