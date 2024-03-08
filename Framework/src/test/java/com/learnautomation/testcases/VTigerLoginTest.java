package com.learnautomation.testcases;

import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

public class VTigerLoginTest extends BaseClass {

	@Test
	public void Login()
	{
		LoginPage lp=new LoginPage(driver);
		lp.LoginInToVtiger("admin", "admin");
	}

}
