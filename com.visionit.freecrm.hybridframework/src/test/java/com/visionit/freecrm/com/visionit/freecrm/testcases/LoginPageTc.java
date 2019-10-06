package com.visionit.freecrm.com.visionit.freecrm.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.visionit.freecrm.pageobjects.LoginPage;
import com.visionit.freecrm.testbase.Baseclass;

public class LoginPageTc extends Baseclass
{
	LoginPage login;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		Reporter.log("Before navigating to browser, we are getting the browsername to launch respective browser.. ");
		
		String browserName=configDataProvider.getConfigProperties("chBrowser");
		String url=configDataProvider.getConfigProperties("url");
		
		Reporter.log("launching the browser:   "+ browserName, true);
		Reporter.log("Navigating to url:  "+ url, true );
		browserStartUp(browserName, url);
		
		Reporter.log("initializing login page object ", true);
		
		login = new LoginPage(driver);
		Thread.sleep(5000);
		
	}

	@Test(priority = 4, dataProvider = "getExcelData")
	public void verifyloginToCrmProTest(String uname, String upwd) {
		
		Reporter.log("Create login Test before start it..", true);
		
		logger=extent.createTest("Veryfying crmpro login ...");
		
		logger.info("before going to login into crm ...");
		
		login.verifyloginToCrmPro(uname, upwd);
		
		boolean status=driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")).isDisplayed();

		if (status) {

			logger.pass("Login successfully....");
			Assert.assertTrue(true);

			//login.verifyLogoutCrmPro();
			
		} else {

			logger.fail("Login failed....");
			System.out.println("can't find element");
		
			Assert.assertTrue(false);
		}
		
		Reporter.log("login Test completed and checkout the results in reports..", true);

	}

	@DataProvider
	public Object[][] getExcelData() {

		Object[][] data = excelDataProvider.getExcelData("Sheet2");

		return data;
	}
}
