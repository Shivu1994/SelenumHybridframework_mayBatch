package com.visionit.freecrm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider 
{
public static Properties prop;
	
	public ConfigDataProvider() {
		
		try {

			File fs = new File(".//Config//prop.properties");
			FileInputStream fis = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {

			System.out.println("File not found :" + e.getMessage());
		}
	}
	
	public String getConfigProperties(String keyValue)
	{
		return prop.getProperty(keyValue);		
	}
	public String getUserName()
	{
		return prop.getProperty("username");		
	}
	
	public String getUserpass()
	{
		return prop.getProperty("userpass");		
	}
	
	public String getChromeBrowser()
	{
		return prop.getProperty("chBrowser");		
	}
	
	
}
