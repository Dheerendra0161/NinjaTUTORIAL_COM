package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
			System.out.println();
		//driver.findElement(By.id("input-email")); 
System.getProperties().list(System.out);
		
	}
	}


