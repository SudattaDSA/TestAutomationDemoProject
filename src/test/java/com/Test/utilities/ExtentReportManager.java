package com.Test.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	public static ExtentReports getReports() {
		if(extent==null) {
			extent=new ExtentReports();
			spark=new ExtentSparkReporter(System.getProperty("user.dir")+"\\extentreports\\");
			spark.config().setReportName("Test Automation Demo Project");
			spark.config().setDocumentTitle("Report");
			spark.config().setTheme(Theme.DARK);
			spark.config().setEncoding("utf-8");
			extent.attachReporter(spark);
		}
		return extent;
	}
	
}
