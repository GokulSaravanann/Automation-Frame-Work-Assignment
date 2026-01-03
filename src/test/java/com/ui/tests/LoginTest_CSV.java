package com.ui.tests;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest_CSV extends TestBase {
	
	HomePage hp;

	
	
	
	@Test(description = "Login test", dataProviderClass = com.ui.Dataprovider.LoginDataProvider.class,
			dataProvider = "loginCSVDataProvider")
	public  void loginTest(User user) {
	
	String name = hp.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName();
	System.out.println("Logged in user: " + name);
		
	}

}
