package com.visionit.freecrm.com.visionit.freecrm.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.visionit.freecrm.pageobjects.LoginPage;
import com.visionit.freecrm.pageobjects.SignUpPage;
import com.visionit.freecrm.testbase.Baseclass;

public class SignUpPageTc extends Baseclass
{
	LoginPage login;
	SignUpPage signUp;

	@BeforeMethod
	public void setUp() {

		browserStartUp(configDataProvider.getConfigProperties("chBrowser"),
				configDataProvider.getConfigProperties("url"));
		login = new LoginPage(driver);
		signUp = login.navigateToCreateAnAccountPage();
	}

	
	@Test(dataProvider = "getExcelData")
	public void createAnFreeCrmProAccountTest(String ddValue, String fname, String lname, String email, String confirmEmail,
			String unameField, String upassField, String confirmUserpass, String company, String phone, String desText,
			String addText, String countryDD) {

		signUp.createAnFreeCrmProAccount(ddValue, fname, lname, email, confirmEmail, unameField, upassField, confirmUserpass,
				company, phone, desText, addText, countryDD);
	}
	
	
	@DataProvider
	public Object [][] getExcelData(){
		
		Object[][] data = excelDataProvider.getExcelData("Sheet2");

		return data;
	}

	
}
