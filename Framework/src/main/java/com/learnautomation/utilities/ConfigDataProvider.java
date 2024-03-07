package com.learnautomation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	FileInputStream fis;
	Properties pro;
	public static void main(String[] args)
	{
		ConfigDataProvider c=new ConfigDataProvider();
		System.out.println(c.getBrowser());
	}
	
	public ConfigDataProvider()
	{
		
		try {
			fis = new FileInputStream("./src/main/resources/ConfigFiles/v.properties");
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("File cannot be loaded "+e.getMessage());
		}
		}
	public String getDataFromConfig(String Key)
	{
		return pro.getProperty(Key);
	}
	public String getURL()
	{
		return pro.getProperty("qaURL");
	}
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}

}
