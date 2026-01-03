package com.ui.tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.LoggerUtility;






@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {
	
	

	@Test(description = "Login test", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public  void loginTest() {
		
	
	String name = hp.goToLoginPage().doLoginWith("bakomam596@skrak.com","password").getUserName();
	System.out.println("Logged in user: " + name);
	
	Assert.assertEquals(true, "Jatin Sharmsa");
	
		
		
	}
//	@Test(description = "Login testValid", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public  void loginTestValid() {
//		
//	
//	String name = hp.goToLoginPage().doLoginWith("bakomam596@skrak.com","password").getUserName();
//	System.out.println("Logged in user: " + name);
//	
////	Assert.assertEquals(true, "Jatin Sharma");
//	if(name.equalsIgnoreCase("Jatin sharma")) {
//		System.out.println("User is expected");
//	}else {
//		System.out.println("User is not expected");
//	}
//	
//		
		
//	}

}
