 package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase_Before_Parameter {

	HomePage hp;
	Logger logger = LoggerUtility.getLogger(getClass());
	
	@BeforeMethod(description = "ChromeDriver Launch")
	public void setUp() {
			logger.info("!!!ChromeDriver Launched successfully");
	//		hp = new HomePage(Browser.CHROME);
		
	}
	
	public BrowserUtility  getInstance() {
		return hp;
	}
	
	@AfterMethod
	public void tearDown() {
		
		hp.quit(); //quits the local session
		
	}
	

}
