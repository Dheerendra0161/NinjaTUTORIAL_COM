package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Search extends Base {

	public WebDriver driver;

	LoginPage loginPage;

	public Search() throws IOException {
		super();
//	Note:	To explicitly call the superclass constructor from the subclass constructor, we use super() keyword. 
//		super() can be used only inside the subclass constructor and must be the first statement.
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		loginPage = homepage.navaigateToLoginPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test()
	public void verifyProductSearch() {
		System.out.println("");

	}

}
