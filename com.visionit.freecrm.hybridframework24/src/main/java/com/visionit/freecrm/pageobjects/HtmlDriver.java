package com.visionit.freecrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HtmlDriver 
{
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		
		ChromeOptions option=new ChromeOptions();
		
		option.addArguments("--");

		WebDriver driver=new ChromeDriver(option);
		
		driver.get("http://www.facebook.com/");
		System.out.println(driver.getTitle());
		driver.close();

	}

}
