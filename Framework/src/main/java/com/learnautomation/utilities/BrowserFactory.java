package com.learnautomation.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BrowserFactory {

	

	public static WebDriver startApplication(String BrowserName,String URL,WebDriver driver) {
		if (BrowserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("We do not support this browser");
		}
		driver.get(URL);
		return driver;
		

	}

	public static void maximiseScreen(WebDriver ldriver) {
		ldriver.manage().window().maximize();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}

	public static void quitBrowser(WebDriver ldriver) {
		ldriver.quit();

	}

}
