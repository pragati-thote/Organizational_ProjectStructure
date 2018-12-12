package com.qa.testcases;

import org.testng.annotations.Test;
import com.qa.base.BaseClass;
import com.qa.pages.Dashboardpage;
import com.qa.pages.Loginpage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.annotations.AfterMethod;

public class LoginpageTest extends BaseClass{
	
	Dashboardpage dashboard;
	Loginpage login;
	
	
   public LoginpageTest() throws IOException {
	   super();
		// TODO Auto-generated constructor stub
	}
  
  @BeforeMethod
  public void setUp() throws IOException {
	initialization(); 
	login=new Loginpage(driver) ;
  }
  
  @Test(priority=1)
  public void loginPageTitleTest() {
	String title= login.validatePageTitle();
	assertEquals(title,"Login | Bynry"); 
  }
  
  @Test(priority=2)
  public void loginPageFormTitle()
  {
	 String formTitle= login.validateLoginFormTitle();
	 assertEquals(formTitle, "Login to your account");
  }
  
  @Test(priority=2)
  public void loginPageLogoTest()
  {
	login.validateAppLogo();
  }
  
  @DataProvider()
  public void getLoginTestData()
  {
	  
  }
  
  
  @Test(priority=3)
  public void loginTest() {
	dashboard= login.login(prop.getProperty("username"), prop.getProperty("password"));
	
  }

  @AfterMethod
  public void tearDown() {
  driver.quit();
  }

}