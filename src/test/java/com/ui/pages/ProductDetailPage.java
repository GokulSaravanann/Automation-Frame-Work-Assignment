package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility{
	
	private static final By SIZE_DROPDOWN = By.id("group_1");
	private static final By SELECT_COLOR = By.id("color_8");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.id("add_to_cart");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");

	public ProductDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	


	public ProductDetailPage changeSize(Size size) {
		selectByDropdown(SIZE_DROPDOWN, size.toString());
		return new ProductDetailPage(getDriver());
	}
	
	public ProductDetailPage addToCart() {
		clickOn(SELECT_COLOR);
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailPage(getDriver());
		
	}
	public ShoppingCartPage proceedToCheckOut() {
		
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
		return shoppingCartPage;
		
	}
	
	
}
