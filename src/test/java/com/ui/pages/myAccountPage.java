package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class myAccountPage extends BrowserUtility {
	
	private static final By USER_NAME = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_DRESS = By.id("search_query_top");
	private static final By ADD_FIRST_ADDRESS = By.xpath("//a[@title='Add my first address']");

	public myAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	
	public String getUserName() {
		return getVisibleText(USER_NAME);
	}
	
	
	public SearchResultPage searchDress(String dressName) {
		enterText(SEARCH_DRESS, dressName);
		enterSpecialKey(SEARCH_DRESS, Keys.ENTER);
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		return searchResultPage;
	}

	public AddressPage goToAddressPage() {
		clickOn(ADD_FIRST_ADDRESS);
		AddressPage addressPage = new AddressPage(getDriver());
		return addressPage;
	}

	

}
