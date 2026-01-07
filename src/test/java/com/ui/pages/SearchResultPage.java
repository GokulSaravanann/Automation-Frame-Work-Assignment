package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility{
	
	private static final By SEARCH_TITLE = By.xpath("//span[@class='lighter']");
	private static final By ALL_DRESS_NAMES = By.xpath("//div[@class='product-container']//a[@class='product-name']");

	public SearchResultPage(WebDriver driver)  {
		super(driver);
	}

	
	
	public String getSearchTitle() {
		return getVisibleText(SEARCH_TITLE);
	}
	
	public boolean isSearchResultsContainsRequiredString(String RequiredNames) {
		
		List<String> keywords = Arrays.asList(RequiredNames.split(" "));
		List<String> productList = getAllVisibleText(ALL_DRESS_NAMES);
		
	boolean result = productList.stream().anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
	return result;
	}
	
	
	public ProductDetailPage selectFirstDress(int index) {
		clickOnElement(getAllElement(ALL_DRESS_NAMES).get(index));
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
	}
}
