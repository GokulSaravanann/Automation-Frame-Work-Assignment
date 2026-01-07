package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility {
	
	private static final By CHECKBOX_SHIPPING = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT_CONFIRMADDRESS_PAGE = By.name("processCarrier");

	public ShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public ShippingPage checkTermsAndService() {
		clickOn(CHECKBOX_SHIPPING);
		return new ShippingPage(getDriver());
	}
	
	public PaymentPage goToPaymentPage() {
		clickOn(PROCEED_TO_CHECKOUT_CONFIRMADDRESS_PAGE);
		PaymentPage paymentPage = new PaymentPage(getDriver());
		return paymentPage;
	}
}
