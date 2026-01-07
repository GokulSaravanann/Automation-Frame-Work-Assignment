package com.ui.tests;

import org.testng.annotations.Test;

import com.ui.pojo.AddressPojo;
import com.utility.FakeAddressUtility;

public class AddNewAddressTest extends TestBase {
	
	private String user = "bakomam596@skrak.com";
	private String pass = "password";
	private AddressPojo addressPojo;
	
	@Test(description = "Add first address", groups = {"e2e", "sanity", "smoke"})
	public void addAddress() {
		
		addressPojo = FakeAddressUtility.generateFakeAddress();
				
		String confirmation = hp.goToLoginPage().doLoginWith(user, pass).goToAddressPage().saveAddress(addressPojo);
		System.out.println("!!!!!!"+confirmation+"!!!!!");
		}

}
