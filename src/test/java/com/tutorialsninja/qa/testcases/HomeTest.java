package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;

public class HomeTest extends Base {

	HomePage homePage;

	public HomeTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.http.factory", "jdk-http-client"); // Just to launch chrome setting after updation
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void checkingElementDisplayedAndEnabled() {

		Assert.assertTrue(homePage.itemsAddtoCart());
		Assert.assertTrue(homePage.searchButton());
		Assert.assertTrue(homePage.searchBox());
		Assert.assertTrue(homePage.wishList());
		Assert.assertTrue(homePage.shoppingCart());
		Assert.assertTrue(homePage.Checkout());
		Assert.assertTrue(homePage.Currency());

	}

}
