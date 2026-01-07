package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(getClass());
	private WebDriverWait wait;

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
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
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
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
			
			else {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}
	}
		else if(browserName == Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
			
			else {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}
		}
		else {
			System.out.println("Invalid browser");
		}
	}
	
	
	
	
	public void goToWebsite(String url) {
		logger.info("URL is passed to browser!!!!!");
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
	
	//	WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	
	public void enterText(By locator, String text) {
		//WebElement element = driver.get().findElement(locator);
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}
	public void enterSpecialKey(By locator, Keys KeyToEnter) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(KeyToEnter);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding element of the locator!!!!!");
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}
	
	public String getVisibleText(WebElement element) {
		return element.getText();
	}
	
	
	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding All elements of the locator!!!!!");
		List<WebElement> elementList = driver.get().findElements(locator);
		List<String> listOfElement = new ArrayList<String>();
		for(WebElement element : elementList) {
			listOfElement.add(getVisibleText(element));
		}
		return listOfElement;
	}
	public List<WebElement> getAllElement(By locator) {
		logger.info("Finding All elements of the locator!!!!!");
		List<WebElement> elementList = driver.get().findElements(locator);
		
		return elementList;
	}
	
	
	public void selectByDropdown(By locator, String optionToSelect) {
		logger.info("selecting dropdown elements with locator!!!!!"+locator);
		WebElement element = driver.get().findElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(optionToSelect);
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
