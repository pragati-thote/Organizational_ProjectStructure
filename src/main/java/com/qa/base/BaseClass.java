package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.util.Util;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop=new Properties();
	
	//Constructor
	public BaseClass() throws IOException
	{
		try 
		{
			FileInputStream fin=new FileInputStream("/home/bynry01/Documents/Own/My_Projects/Organisational_Level/src/main/java/com/qa/configuration/config.properties");
			prop.load(fin);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
	}
	
	public static void initialization()
	{		
		String browser_name=prop.getProperty("browser");
		
		if(browser_name.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",prop.getProperty("gickodriver_path"));  
			driver=new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("chrome"))
		{
			System.setProperty("WebDriver.chome.driver","");
			driver=new ChromeDriver();
		}
		else if(browser_name.equalsIgnoreCase("IE"))
		{
			System.setProperty("WebDriver.IE.driver", "");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIME,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

	}
	
}