package com.learnautomation.utilities;

import java.io.File;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static String takesScreentshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//Screenshots//Framework_"+getCurrentDate()+".png");
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/Framework_"+getCurrentDate()+".png";
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Screenshot captured successfully");
		return screenshotpath;

	}

	public static String getCurrentDate() {
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);

	}

	public void handleFrames() {

	}

	public void handleAlert() {

	}



}
