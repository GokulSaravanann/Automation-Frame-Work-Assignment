package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(getClass());

//When ever threadlocal comes into initialization for variable
//get an set methods are used for corresponding variable across methods 
//for eg.,	
// before -	return driver; after return driver.get();
	
	public WebDriver getDriver() {
		return driver.get();
	}

	//Purpose of constructor is to initialize the instance variable
	
	public BrowserUtility(WebDriver driver) {
		super();
		BrowserUtility.driver.set(driver);
	}
	
//	public BrowserUtility(Browser browserName) {
//		
//		if(browserName == Browser.CHROME) {
//			driver.set(new ChromeDriver());
//		}
//		
//		else if(browserName == Browser.EDGE) {
//			driver.set(new EdgeDriver());
//		}
//		else {
//			System.out.println("Invalid browser");
//		}
//	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		
		if(browserName == Browser.CHROME) {
			
			if(isHeadless) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
			}
			
			else {
			driver.set(new ChromeDriver());
		}
	}
		else if(browserName == Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			}
			
			else {
			driver.set(new EdgeDriver());
		}
		}
		else {
			System.out.println("Invalid browser");
		}
	}
	
	
	
	
	public void goToWebsite(String url) {
		logger.info("URL is passed to chrome!!!!!");
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
	
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String text) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
	}
	
	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}
	
	public String takeScreenshot(String name) {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		String Path = System.getProperty("user.dir") + "//screenshots//"+name+ " - "+timestamp+".png";
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File(Path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Path;
	}

}
