package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.constants.Size;

public class CheckOutTest extends TestBase{
	
	private String user = "bakomam596@skrak.com";
	private String pass = "password";
	private String dressName = "Printed Summer Dress";
	
	@Test(description = "Checkout the printed summary dress")
	public void checkOut()  {
	
	String orderConfirmationMsg =	hp.goToLoginPage()
		.doLoginWith(user, pass)
		.searchDress(dressName)
		.selectFirstDress(1)
		.changeSize(Size.L)
		.addToCart().proceedToCheckOut()
		.proceedToCheckOut()
		.proceedToCheckOutConfirmAddressPage()
		.checkTermsAndService()
		.goToPaymentPage()
		.confirmPayment()
		.verifyOrderConfirmation();
	Assert.assertEquals(orderConfirmationMsg, "Your order on My Shop is complete.");
	}
}
