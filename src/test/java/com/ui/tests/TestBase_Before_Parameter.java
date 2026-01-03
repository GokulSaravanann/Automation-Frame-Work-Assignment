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
	
	private boolean isLambdaTest = false;
	private boolean isHeadless = true;
	
	protected HomePage hp;
	Logger logger = LoggerUtility.getLogger(getClass());
	
	@Parameters({"browser", "isLambdaTest", "isHeadless"} )
	@BeforeMethod(description = "ChromeDriver Launch")
	public void setUp(String browser, boolean isLambdaTest, boolean isHeadless, ITestResult result) {
		WebDriver lambdaDriver;
		if(isLambdaTest) {
			
			lambdaDriver = LamdaTestUtility.initializeLamdaTestSession("chrome", result.getMethod().getMethodName());
			hp = new HomePage(lambdaDriver);
		}
		else {
			
			logger.info("!!!ChromeDriver Launched successfully");
			hp = new HomePage(Browser.CHROME, isHeadless);
		}	
	}
	
	public BrowserUtility  getInstance() {
		return hp;
	}
	
	@AfterMethod
	public void tearDown() {
		
		if(isLambdaTest) {
			LamdaTestUtility.quitLamdaSession(); // quits the lambda session
		}else {
			hp.quit(); //quits the local session
		}
	}
	

}
