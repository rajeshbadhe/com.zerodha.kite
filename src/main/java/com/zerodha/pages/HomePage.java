package com.zerodha.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	@FindBy(xpath="//input[@id='search-input']")
	private WebElement eleSearch;
	
	@FindBy(xpath="//button[@class='button-blue buy']")
	private WebElement eleBuy;
	
	
}
