package com.learnautomation.testcases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
//import com.learnautomation.utilities.ExcelDataProvider;

public class LoginTestVtiger extends BaseClass {

	ITestResult result;

	@Test
	public void loginApp() {
		
		LoginPage lp = new LoginPage(driver);

		// Assert.fail();

		lp.LoginInToVtiger("admin", "admin");

		// e.getStringData(0, 0, 0);

	}

}
