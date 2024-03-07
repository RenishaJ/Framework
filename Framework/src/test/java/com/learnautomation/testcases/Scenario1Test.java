package com.learnautomation.testcases;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class Scenario1Test  {
	@Test
	public void ContactProgram()  {

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	    driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	    driver.findElement(By.name("lastname")).sendKeys("Fernandes");
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Fernandes ')]"));
		String ele2 = ele.getText();
		System.out.println(ele2);
		if (ele2.contains("CON")) {
			System.out.println("Contact info successfully saved"); 
		} else {
			System.out.println("Contact info is not saved successfully");
		}
		
		WebElement ele1=driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
		Actions act=new Actions(driver);
		act.moveToElement(ele1);
		driver.findElement(By.xpath("//*[text()='Sign Out']")).click();
		

	}
}
