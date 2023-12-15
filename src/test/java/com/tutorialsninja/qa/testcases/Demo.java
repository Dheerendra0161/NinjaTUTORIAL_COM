package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class Demo extends Base {
	WebDriver driver;

	public Demo() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();

	}

	@Test
	public void Dk() {

		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example")));
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("example"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("example")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("example")));
		wait.until(ExpectedConditions.elementToBeSelected(By.id("example")));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("example"), "expectedText"));

		// Fluent Wait
		Wait<WebDriver> FlunetWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		WebElement element = FlunetWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example")));

	}
}
