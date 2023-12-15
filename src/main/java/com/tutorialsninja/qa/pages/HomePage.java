package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//PageObjectModel Design Pattern
public class HomePage {
	public WebDriver driver;

	// WebElements are objects
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccoutDropDown;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(xpath = "//*[contains(text(),'Register')]")
	private WebElement resisterOption;

	@FindBy(id = "cart-total")
	private WebElement itemsAddtoCart;
	
	
	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@class='form-control input-lg']")
	private WebElement searchBox;

	@FindBy(xpath = "//span[text()='Wish List (0)']")
	private WebElement wishList;

	@FindBy(xpath = "//span[text()='Shopping Cart']")
	private WebElement shoppingCart;

	@FindBy(xpath = "//span[text()='Checkout']")
	private WebElement Checkout;

	@FindBy(xpath = "//span[text()='Currency']")
	private WebElement Currency;

	// creating a constructor of HomePage
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// or PageFactory.initElements(driver, HomePage.class);
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

	public boolean itemsAddtoCart() {
		return isElementDisplayAndEnabled(itemsAddtoCart);
	}

	public boolean searchButton() {
		return isElementDisplayAndEnabled(searchButton);

	}
	public boolean searchBox() {
		return isElementDisplayAndEnabled(searchBox);

	}

	public boolean wishList() {
		return isElementDisplayAndEnabled(wishList);
	}

	public boolean shoppingCart() {
		return isElementDisplayAndEnabled(shoppingCart);
	}

	public boolean Checkout() {
		return isElementDisplayAndEnabled(Checkout);
	}

	public boolean Currency() {
		return isElementDisplayAndEnabled(Currency);
	}

	public LoginPage navaigateToLoginPage() {
		myAccoutDropDown.click();
		loginOption.click();
		return new LoginPage(driver); // return used here to navigate to Login.
	}

	public RegisterPage navigateToRegisterPage() {
		myAccoutDropDown.click();
		resisterOption.click();
		return new RegisterPage(driver); // return used here to navigate to Register.
											// here we provided driver because of the RegisterPage constructor contains
											// the driver on RegisterPage.
	}

}
