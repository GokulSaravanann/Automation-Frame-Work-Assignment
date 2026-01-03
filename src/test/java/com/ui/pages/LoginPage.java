package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility{

	public LoginPage(WebDriver driver) {
		super(driver);

	}
	
	private static final By EMAIL = By.id("email");
	private static final By PASSWORD = By.id("passwd");
	private static final By SIGN_IN_BUTTON = By.id("SubmitLogin");
	
	
	public myAccountPage doLoginWith(String mail, String pass) {
		enterText(EMAIL, mail);
		enterText(PASSWORD, pass);
		clickOn(SIGN_IN_BUTTON);
		
		myAccountPage accnt= new myAccountPage(getDriver());
		return accnt;
	}
	
	
	


}
