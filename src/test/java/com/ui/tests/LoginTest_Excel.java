package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
public class LoginTest_Excel extends TestBase {
	Logger logger = LoggerUtility.getLogger(this.getClass());	
	HomePage hp;

	
	
	@Test(description = "Login test", dataProviderClass = com.ui.Dataprovider.LoginDataProvider.class,
			dataProvider = "loginExcelDataProvider")
	public  void loginTest(User user) {
	
		logger.info("Login Excel test started!!!!!!");
		
	String name = hp.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName();
	System.out.println("Logged in user: " + name);
		
	logger.info("Login Excel test completed!!!!!!");
		
		
	}

}
