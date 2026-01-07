package com.ui.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;







@Listeners(com.ui.listeners.TestListener.class)
public class LoginTestExcel extends TestBase {
	
	

	

	@Test(description = "Login test EXCEL", dataProviderClass = com.ui.Dataprovider.LoginDataProvider.class,
			dataProvider = "loginExcelDataProvider")
	public  void loginTestExcel(User user) {
	
		logger.info("Login Excel test started!!!!!!");
		
	String name = hp.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName();
	System.out.println("Logged in user: " + name);
		
	logger.info("Login Excel test completed!!!!!!");
		
		
	}
	
}
