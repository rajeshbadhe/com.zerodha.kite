package com.zerodha.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zerodha.base.BaseClass;
import com.zerodha.pages.LoginPage;

public class LoginPageTest extends BaseClass
{
	public LoginPageTest() throws Exception
	{
		super();
	}
	
	
	@BeforeMethod
	public void openBrowserAndAppMethod() throws Exception 
	{
		openBrowserAndApplication();
		objLoginPage=new LoginPage();
	}
	
	@Test(priority=2)
	public void loginMethod()
	{
		
		try 
		{
			objPinPage=objLoginPage.setUserNamePasswordOnLoginPage(prop.getProperty("username"),prop.getProperty("password"));
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=1)
	public void titalCheck() throws Exception
	{	
		Assert.assertTrue(objLoginPage.checkTital());
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		
		driver.quit();
	}
}
