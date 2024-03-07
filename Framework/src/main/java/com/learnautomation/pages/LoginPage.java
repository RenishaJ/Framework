package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//input[@type='text']")
	private WebElement username;
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	@FindBy(id="submitButton")
	private WebElement sbtbutton;

	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void LoginInToVtiger(String Uname,String Upassword)
	{
		username.sendKeys(Uname);
		password.sendKeys(Upassword);
		sbtbutton.click();
	}

}
