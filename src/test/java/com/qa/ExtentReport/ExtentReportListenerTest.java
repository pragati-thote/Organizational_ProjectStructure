package com.qa.ExtentReport;



import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;		
	

public class ExtentReportListenerTest {				
WebDriver driver= new FirefoxDriver();					

// Forcefully failed this test as to verify listener.		
@Test		
public void TestToFail()				
{		
    System.out.println("This method to test fail");					
    Assert.assertTrue(false);			
}		
}