package com.qa.ExtentReoprtListener;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport implements IReporter
	{
	 private ExtentReports extent ;
	 
	 public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>Suites, String outputDirectory)
	 {
		 extent=new ExtentReports(outputDirectory+File.separator+"MRBD_ExtentReport.html", true);
		 
		 for(ISuite Suite:Suites)
		 {
			 Map<String, ISuiteResult> result=Suite.getResults();
			 
			 for(ISuiteResult r: result.values())
			 {
				 ITestContext context=r.getTestContext();
				 buildTestNodes(context.getPassedTests(),LogStatus.PASS);
				 buildTestNodes(context.getFailedTests(),LogStatus.FAIL);
				 buildTestNodes(context.getSkippedTests(),LogStatus.SKIP);
				 
			 }
		 }
		 
		 extent.flush();
		 extent.close();
		 
	 }

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		
		ExtentTest test;
		
		if(tests.size()>0)
		{
			for(ITestResult result: tests.getAllResults())
			{
				test=extent.startTest(result.getMethod().getMethodName());
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getStartMillis()));
				
				for(String group:result.getMethod().getGroups())
				{
				 if(result.getThrowable()!=null)
				 {
					 test.log(status, result.getThrowable());
				 }
				 else
				 {
					 test.log(status, "Test"+ status.toString().toLowerCase()+"eq");
				 }
				 
				 extent.endTest(test);
				}
			}
		}
		
		
	}
		
	private Date getTime(long millis)
	{
		Calendar calender=Calendar.getInstance();
		calender.getTimeInMillis();
		return calender.getTime();
	}
}
