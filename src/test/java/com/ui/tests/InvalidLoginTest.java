package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends TestBase{

	@Test(description = "Verify user gets error message for invalid login", groups = {"sanity", "e2e", "smoke"})
	public void loginTest() {
		
		Assert.assertEquals(hp.goToLoginPage().doLoginWithInvalidCred("abchd@mail.com", "hbhbk").verifyAuthenticationFailed(),
				"Authentication failed.");
		
	}

	
		
	
}
