package com.qa.pages;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	Dashboardpage dashboard;
	
	@FindBy(name="username")WebElement user_id;
	@FindBy(xpath="//input[@type='password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement login_btn;
	@FindBy(xpath="//div[@class='logo1']")WebElement app_logo;
	@FindBy(className="form-title")WebElement form_title;
	
	
	public Loginpage(WebDriver webDriver) throws IOException {
	        //This initElements method will create all WebElements
		this.driver = webDriver;
	    PageFactory.initElements(webDriver, this);
	}
	
	
	//Actions
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	
	public String validateLoginFormTitle()
	{
		return form_title.getText();
	}
	
	
	public String validateAppLogo()
	{
		return app_logo.getText();	
	}
	
	public Dashboardpage login(String uid, String pwd)
	{
		user_id.clear();
		user_id.sendKeys(uid);
		password.clear();
		password.sendKeys(pwd);
		
		login_btn.click();
		
		//After clicking on login button it redirects on dashboard page
		//There for this method return dashboard page object
		//make method return type as Dashboardpage (it is class name)
		
		return dashboard;
	}	
	
}