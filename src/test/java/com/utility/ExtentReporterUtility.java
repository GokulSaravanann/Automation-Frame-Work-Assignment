package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	
	static ExtentSparkReporter extentSparkReporter;
	static ExtentReports extentReports;
	static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static void setUpSparkReporter() {
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\report.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}
	
	public static void createExtentTest(String testName) {
		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);
		}
	
	public static ExtentTest getTest() {
		return extentTest.get();
	}
	
	public static void flushReport() {
		extentReports.flush();
	}

	
}


