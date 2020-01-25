package com.zerodha.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zerodha.base.BaseClass;

public class LoginPage extends BaseClass
{
	@FindBy(xpath="//div[@class='uppercase su-input-group']/input")
	private WebElement eleUN;
	
	@FindBy(xpath="//div[@class='su-input-group']/input")
	private WebElement elePWD;
	
	@FindBy(xpath="//a[@class='logo kite-logo']//img")
	private WebElement elelogo;
	
	@FindBy(xpath="//button[text()='Login ']")
	private WebElement eleBtn;
	
	
	public LoginPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkTital() throws InterruptedException 
	{
		return elelogo.isDisplayed();
			
	}
	
	public PinPage setUserNamePasswordOnLoginPage(String strUN, String strPWD) throws Exception
	{
		
		eleUN.sendKeys(strUN);
		
		elePWD.sendKeys(strPWD);
		eleBtn.click();
		return new PinPage();
	}
}
