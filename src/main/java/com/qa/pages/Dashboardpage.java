package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboardpage {
	
	
	WebDriver driver;
	
	
	public Dashboardpage(WebDriver webDriver) throws IOException {
	        //This initElements method will create all WebElements
		this.driver = webDriver;
	    PageFactory.initElements(webDriver, this);
	}
	
	//Actions
	
	public String verifyDashboardPageTitle()
	{
		return driver.getTitle();
	}
	
	
	

}
