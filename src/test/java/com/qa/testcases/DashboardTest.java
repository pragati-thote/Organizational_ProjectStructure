package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.Dashboardpage;
import com.qa.pages.Loginpage;

public class DashboardTest extends BaseClass{
	Loginpage login;
	Dashboardpage dashboard; 
	
	
	   public DashboardTest() throws IOException {
		   super();
			// TODO Auto-generated constructor stub
		}
	  
	  @BeforeMethod
	  public void setUp() throws IOException {
		initialization(); 
		login=new Loginpage(driver);
		dashboard=login.login(prop.getProperty("username"), prop.getProperty("password"));
	  }
	  
	  @Test(priority=1)
	  public void DashboardPageTitleTest() throws IOException {
		dashboard=new Dashboardpage(driver);
		String title= dashboard.verifyDashboardPageTitle();
		System.out.println("dashboard page title: "+title);
	  }
	  
	  
	  
	  
	  
	  

	  @AfterMethod
	  public void tearDown() {
	  driver.quit();
	  }
}
