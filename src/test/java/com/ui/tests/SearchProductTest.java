package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase{
	
	private String user = "bakomam596@skrak.com";
	private String pass = "password";
	private String dressName = "Printed Summer Dress";
	
	
	@Test(description = "Search product", groups= {"e2e", "smoke", "sanity"})

	public void SearchProductTest() {
		boolean result = hp.goToLoginPage().doLoginWith(user, pass).searchDress(dressName)
		 .isSearchResultsContainsRequiredString(dressName);
		Assert.assertEquals(result, true);
	}
}
