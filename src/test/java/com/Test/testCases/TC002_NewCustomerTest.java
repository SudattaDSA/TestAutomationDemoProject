package com.Test.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Test.pageObjects.NewCustomer;
import com.Test.pageObjects.loginPage;
import com.Test.utilities.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TC002_NewCustomerTest extends BaseClass {
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	loginPage lp;
	NewCustomer newCustomer;

	@BeforeMethod
	public void initializeNewCustomerTest() {
		extent = ExtentReportManager.getReports();
		test = extent.createTest("New Customer Page");
	}

	@AfterMethod
	public void finish() {
		extent.flush();
	}

	@Test
	public void newCustomerTest() {
		try {
			driver.get(baseURL);
			logger.info("Application is launched.");
			test.log(Status.INFO, "Application is launched.");

			lp = new loginPage(driver);
			lp.setUserName(username);
			logger.info("Username is entered.");
			test.log(Status.INFO, "Username is entered.");

			lp.setPassword(password);
			logger.info("Password is entered.");
			test.log(Status.INFO, "Password is entered.");

			lp.clickLogin();
			logger.info("Login button is clicked.");

			if (driver.getTitle().equalsIgnoreCase(homePageTitle)) {
				Assert.assertTrue(true);
				logger.info("Home Page is launched successfully.");
				test.log(Status.PASS, "Home Page is launched successfully.");
			} else {
				Assert.assertFalse(false);
				logger.info("Home Page is not launched successfully.");
				test.log(Status.FAIL, "Home Page is not launched successfully.");
				captureScreen(driver,"newCustomerTest");
			}

			newCustomer = new NewCustomer(driver);
			newCustomer.clickNewCustomer();
			logger.info("New Customer link is clicked.");
			test.log(Status.INFO, "New Customer link is clicked.");

			if (driver.getTitle().equalsIgnoreCase(newCustomerPageTitle)) {
				Assert.assertTrue(true);
				logger.info("New Customer Page is launched successfully.");
				test.log(Status.PASS, "New Customer Page is launched successfully.");
			} else {
				Assert.assertFalse(false);
				logger.info("New Customer Page is not launched successfully.");
				test.log(Status.FAIL, "New Customer Page is not launched successfully.");
				captureScreen(driver,"newCustomerTest");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}