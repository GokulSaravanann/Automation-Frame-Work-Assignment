package com.ui.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;







@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {
	
	

	@Test(description = "Login test", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public  void loginTest() {
		
	
	String name = hp.goToLoginPage().doLoginWith("bakomam596@skrak.com","password").getUserName();
	System.out.println("Logged in user: " + name);
	
	Assert.assertEquals(true, "Jatin Sharmsa");
	
		
		
	}


}
