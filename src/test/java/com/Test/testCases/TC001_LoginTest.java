package com.Test.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.Test.pageObjects.loginPage;
import com.Test.utilities.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TC001_LoginTest extends BaseClass {
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;

	@BeforeMethod
	public void initializeLoginTest() {
		extent = ExtentReportManager.getReports();
		test = extent.createTest("Login Test");
	}

	@AfterMethod
	public void finish() {
		extent.flush();
	}

	@Test
	public void loginTest() throws IOException {
		try {
			driver.get(baseURL);
			logger.info("Application is launched.");
			test.log(Status.INFO, "Application is launched.");

			loginPage lp = new loginPage(driver);
			lp.setUserName(username);
			logger.info("Username is entered.");
			test.log(Status.INFO, "Username is entered.");

			lp.setPassword(password);
			logger.info("Password is entered.");
			test.log(Status.INFO, "Password is entered.");

			lp.clickLogin();
			logger.info("Login button is clicked.");

			Thread.sleep(2000);

			if (driver.getTitle().equalsIgnoreCase(homePageTitle)) {
				Assert.assertTrue(true);
				logger.info("Home Page is launched successfully.");
				test.log(Status.PASS, "Home Page is launched successfully.");
			} else {
				Assert.assertFalse(false);
				logger.info("Home Page is not launched successfully.");
				test.log(Status.FAIL, "Home Page is not launched successfully.");
				captureScreen(driver,"loginTest");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}