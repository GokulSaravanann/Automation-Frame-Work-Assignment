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
	private static final By AUTHENTICATION_ERROR = By.xpath("//div[@class='alert alert-danger']//ol//li");
	
	
	public myAccountPage doLoginWith(String mail, String pass) {
		enterText(EMAIL, mail);
		enterText(PASSWORD, pass);
		clickOn(SIGN_IN_BUTTON);
		
		myAccountPage accnt= new myAccountPage(getDriver());
		return accnt;
	}
	
	
	public LoginPage doLoginWithInvalidCred(String mail, String pass) {
		enterText(EMAIL, mail);
		enterText(PASSWORD, pass);
		clickOn(SIGN_IN_BUTTON);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	public String verifyAuthenticationFailed() {
		return getVisibleText(AUTHENTICATION_ERROR);
	}

}
