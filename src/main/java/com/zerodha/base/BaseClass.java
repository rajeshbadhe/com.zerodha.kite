package com.zerodha.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.zerodha.pages.HomePage;
import com.zerodha.pages.LoginPage;
import com.zerodha.pages.PinPage;
import com.zerodha.util.UtilClass;

public class BaseClass 
{
	public static WebDriver driver;
	public Properties prop=null;
	public LoginPage objLoginPage=null;
	public PinPage objPinPage=null;
	public HomePage objHomePage=null;
	
	public BaseClass() throws Exception  
	{
		prop=new Properties();
		FileInputStream file=new FileInputStream("./src/main/java/com/zerodha/config/config.properties");
		prop.load(file);
	}
	
	
	public void openBrowserAndApplication() throws Exception
	{
		if(prop.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(UtilClass.page_load_tiemout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilClass.implicit_wait, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}
	
}
