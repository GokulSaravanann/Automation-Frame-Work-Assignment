package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.ui.pojo.AddressPojo;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility{
	
	private static final By COMPANY_TEXT_BOX = By.id("company");
	private static final By ADDRESS1_TEXT_BOX = By.id("address1");
	private static final By ADDRESS2_TEXT_BOX = By.id("address2");
	private static final By CITY_TEXT_BOX = By.id("city");
	private static final By POSTCODE_TEXT_BOX = By.id("postcode");
	private static final By HOMEPHONE_TEXT_BOX = By.id("phone");
	private static final By MOBILENO_TEXT_BOX = By.id("phone_mobile");
//	private static final By ADDITIONAL_INFO_TEXT_BOX = By.id("other");
	private static final By ADDRESS_ALIAS_TEXT_BOX = By.id("alias");
	private static final By STATE_DRIPDOWN = By.id("id_state");
	private static final By SAVE_ADDRESS = By.id("submitAddress");
	
	private static final By ADDRESS_ADDED_CONFIRMATION = By.tagName("h3");

	public AddressPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String saveAddress(AddressPojo addpojo) {
		enterText(COMPANY_TEXT_BOX, addpojo.getCOMPANY_TEXT_BOX());
		enterText(ADDRESS1_TEXT_BOX, addpojo.getADDRESS1_TEXT_BOX());
		enterText(ADDRESS2_TEXT_BOX, addpojo.getADDRESS2_TEXT_BOX());
		enterText(CITY_TEXT_BOX, addpojo.getCITY_TEXT_BOX());
		enterText(POSTCODE_TEXT_BOX, addpojo.getPOSTCODE_TEXT_BOX());
		enterText(HOMEPHONE_TEXT_BOX, addpojo.getHOMEPHONE_TEXT_BOX());
		enterText(MOBILENO_TEXT_BOX, addpojo.getMOBILENO_TEXT_BOX());
	//	enterText(ADDITIONAL_INFO_TEXT_BOX, addpojo.getADDITIONAL_INFO_TEXT_BOX());
		enterText(ADDRESS_ALIAS_TEXT_BOX, addpojo.getADDRESS_ALIAS_TEXT_BOX());
		selectByDropdown(STATE_DRIPDOWN, addpojo.getSTATE_DRIPDOWN());
		clickOn(SAVE_ADDRESS);
		return getVisibleText(ADDRESS_ADDED_CONFIRMATION);
		 
	}
	
	

}
