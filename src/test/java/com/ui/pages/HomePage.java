package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

//This class will follow page objects pattern


public final class HomePage extends BrowserUtility{
	
	//If something is constant in java final is used, if its final it is static as well
		static final By SIGN_IN = By.xpath("//a[@title='Log in to your customer account']");
	
		Logger logger = LoggerUtility.getLogger(getClass());
	
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		
	logger.info("Browser is launched for URL");
	//	goToWebsite(PropertiesUtil.readProperty(Env.QA, "URL"));
		
		goToWebsite(JsonUtility.readJson(Env.QA).getUrl());

	}
	
	public HomePage(WebDriver driver) { //To call the parent class constructor from child constructor
		super(driver);
		goToWebsite(JsonUtility.readJson(Env.QA).getUrl());
	}

	public LoginPage goToLoginPage() {
		logger.info("Trying to perform login");
		clickOn(SIGN_IN);
		LoginPage login = new LoginPage(getDriver());
		return login;
		
	}

	public void quit() {
	    if (getDriver() != null) {
	        getDriver().quit();
	    }
	}

	










	
	
}
