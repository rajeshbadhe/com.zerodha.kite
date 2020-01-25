package com.zerodha.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zerodha.base.BaseClass;
import com.zerodha.pages.LoginPage;
import com.zerodha.pages.PinPage;
//comment
public class PinPageTest extends BaseClass 
{
	public PinPageTest() throws Exception
	{
		super();
	}
	
	@BeforeMethod
	public void openBrowserAndAppMethod() throws Exception 
	{
		openBrowserAndApplication();
		objLoginPage=new LoginPage();
		objLoginPage.setUserNamePasswordOnLoginPage(prop.getProperty("username"), prop.getProperty("password"));
		objPinPage=new PinPage();
	}
	
	@Test(priority=1)
	public void checkPinPageIsOpened()
	{
		Assert.assertTrue(objPinPage.isUserIDDispalyed(), "Pin page not opened");
	}
	
	
	@Test(priority=2)
	public void setPinAndContinueMethod()
	{
		objHomePage=objPinPage.setPinAndClickOnContinue(prop.getProperty("pin"));
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}
