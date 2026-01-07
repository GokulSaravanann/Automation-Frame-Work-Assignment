package com.ui.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;







@Listeners(com.ui.listeners.TestListener.class)
public class LoginTestCSV extends TestBase {
	
	
	
	@Test(description = "Login testCSV", dataProviderClass = com.ui.Dataprovider.LoginDataProvider.class,
			dataProvider = "loginCSVDataProvider")
	public  void loginTestCSV(User user) {
	
	String name = hp.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName();
	System.out.println("Logged in user: " + name);
		
	}


}
