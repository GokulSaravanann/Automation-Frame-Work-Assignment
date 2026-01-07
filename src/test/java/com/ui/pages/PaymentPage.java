package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {
	
	private static final By PAYMENT_BY_WIRE = By.xpath("//a[@title='Pay by bank wire']");
	private static final By CONFIRM_PAYMENT = By.xpath("//p[@class='cart_navigation clearfix']/button");
	private static final By ORDER_CONFIRMATION_TEXT_LOCATOR = By.xpath("//p[@class='alert alert-success']");
	

	public PaymentPage(WebDriver driver) {
		super(driver);
		
	} 

	public PaymentPage confirmPayment() {
		clickOn(PAYMENT_BY_WIRE);
		clickOn(CONFIRM_PAYMENT);
		return new PaymentPage(getDriver());
	}
	
	public String verifyOrderConfirmation() {
		 return getVisibleText(ORDER_CONFIRMATION_TEXT_LOCATOR);
	}
}
