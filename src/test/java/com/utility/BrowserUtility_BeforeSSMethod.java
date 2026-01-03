package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

public abstract class BrowserUtility_BeforeSSMethod {
	
	
	Logger logger = LoggerUtility.getLogger(getClass());

	private WebDriver driver;  // If a varibale created in a class which is non static means its called as instance variable
						  // Also the value of driver is null here.
	
	
	public WebDriver getDriver() {
		return driver;
	}

	//Purpose of constructor is to initialize the instance variable
	public BrowserUtility_BeforeSSMethod(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public BrowserUtility_BeforeSSMethod(Browser browserName) {
		
		if(browserName == Browser.CHROME) {
			driver = new ChromeDriver();
		}
		
		else if(browserName == Browser.EDGE) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Invalid browser");
		}
	}
	
	
	
	
	public void goToWebsite(String url) {
		logger.info("URL is passed to chrome!!!!!");
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		Logger logger = LoggerUtility.getLogger(getClass());
		WebElement element = driver.findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
	}
	
	public String getVisibleText(By locator) {
		WebElement element = driver.findElement(locator);
		return element.getText();
	}
	
	

}
