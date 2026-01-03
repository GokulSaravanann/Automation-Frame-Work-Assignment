package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener{
	Logger logger = LoggerUtility.getLogger(getClass());
	

	
	public void onTestStart(ITestResult result) {  
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	  }

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+ " " + "PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+ "" + "PASSED");
	  }

	 
	public void onTestFailure(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+ " " + "Failed");
		logger.info(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+"" + "Failed");
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		
		Object testclass = result.getInstance();
		
		BrowserUtility browserutility = ((TestBase)testclass).getInstance();
		logger.info("Capturing screenshot for failed tests");
		String SSPath = browserutility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Attaching the screenshot in HTML file");
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(SSPath);
	}
	
	public void onTestSkipped(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+ " " + "Skipped");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+ ""+"Skipped");
		
		
	  }
	
	public void onStart(ITestContext context) {
		logger.info(context.getName()+"TestCase Started");
		ExtentReporterUtility.setUpSparkReporter();
	}
	  public void onFinish(ITestContext context) {
		  logger.info(context.getName()+"TestCase Failed");
		  ExtentReporterUtility.flushReport();// To create report
	  }
	
	
	

}
