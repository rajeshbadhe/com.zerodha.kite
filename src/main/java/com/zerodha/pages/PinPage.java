package com.zerodha.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zerodha.base.BaseClass;

public class PinPage extends BaseClass
{
	@FindBy(xpath="//div[@class='twofa-value su-input-group su-has-icon']/input")
	private WebElement elePin;
	
	@FindBy(xpath="//div[@class='form-header text-center']/h2")
	private WebElement eleID;
	
	@FindBy(xpath="//button[text()='Continue ']")
	private WebElement eleCntBtn;
	
	
	public PinPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean isUserIDDispalyed()
	{
		return eleID.isDisplayed();
	}
	
	public HomePage setPinAndClickOnContinue(String strPin)
	{
		elePin.sendKeys(strPin);
		eleCntBtn.click();
		return new HomePage();
	}
	
}
