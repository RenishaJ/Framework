package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider e;
	public ConfigDataProvider c;
	public BrowserFactory b;
	public ExtentReports ER;
	public ExtentTest logger;

	@BeforeClass
	public void setup() {
		Reporter.log("Browser is getting ready", true);
		driver = BrowserFactory.startApplication(c.getBrowser(), c.getURL(), driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		System.out.println("The browser has successfully launched by " + c.getDataFromConfig("FirstName"));
		Reporter.log("Browser set up is success", true);
	}

	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
	}

	@BeforeSuite
	public void setupSuite() {

		Reporter.log("Suite set up is getting ready", true);//true also shows in console
		e = new ExcelDataProvider();
		c = new ConfigDataProvider();

		ExtentHtmlReporter EHR = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/" + Helper.getCurrentDate() + ".html"));
		ER = new ExtentReports();
		ER.attachReporter(EHR);
		logger = ER.createTest("LoginToVTiger");
		Reporter.log("Suite set up is success", true);
		

	}

	@AfterMethod
	public void teardownmethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.takesScreentshot(driver);
			try {
				logger.fail("Test Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.takesScreentshot(driver)).build());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			Helper.takesScreentshot(driver);

			try {
				logger.fail("Test Skipped",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.takesScreentshot(driver)).build());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			Helper.takesScreentshot(driver);
		try {
				logger.fail("Test Passed",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.takesScreentshot(driver)).build());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}
		
		ER.flush();
		Reporter.log("Test is completed and reports is generated", true);

	}

}
