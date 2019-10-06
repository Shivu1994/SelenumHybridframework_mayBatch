package com.visionit.freecrm.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.visionit.freecrm.utility.Helper;

public class SignUpPage 
{
	// Repository

		@FindBy(id = "payment_plan_id")
		WebElement selectDD;

		@FindBy(name = "first_name")
		WebElement firstname;

		@FindBy(name = "surname")
		WebElement lastname;

		@FindBy(name= "email")
		WebElement eid;

		@FindBy(name = "email_confirm")
		WebElement confirmEid;

		@FindBy(name = "username")
		WebElement uname;

		@FindBy(name= "password")
		WebElement upass;

		@FindBy(name= "passwordconfirm")
		WebElement confirmPassword;

		@FindBy(xpath = "//input[@type='checkbox']")
		WebElement checkBox;

		@FindBy(name= "submitButton")
		WebElement submitBtn;

		@FindBy(name= "company_name")
		WebElement companyName;
		
		@FindBy(name= "phone")
		WebElement phoneNum;
		
		@FindBy(name= "service")
		WebElement descriptionText;
		
		@FindBy(name= "address")
		WebElement addressText;
		
		@FindBy(name= "btnSubmit")
		WebElement btnSub;
		
		@FindBy(name= "country")
		WebElement countryDD;
		
		@FindBy(name= "finish")
		WebElement completeRegBtn;

		WebDriver driver;

		public SignUpPage(WebDriver driver) {

			this.driver = driver;		
			PageFactory.initElements(driver, this);
		}

		public void createAnFreeCrmProAccount(String ddValue,String fname, String lname, String email, String confirmEmail,
				String unameField, String upassField, String confirmUserpass, String company, String phone, String desText, String addText, String country_DD) {
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Helper.selectValueFromDD(selectDD, ddValue);

			firstname.sendKeys(fname);

			lastname.sendKeys(lname);

			eid.sendKeys(email);

			confirmEid.sendKeys(confirmEmail);

			uname.sendKeys(unameField);

			upass.sendKeys(upassField);

			confirmPassword.sendKeys(confirmUserpass);

			checkBox.click();
			
			submitBtn.click();
			
			companyName.sendKeys(company);
			
			phoneNum.sendKeys(phone);
			
			descriptionText.sendKeys(desText);
			
			addressText.sendKeys(addText);
			
			Helper.selectValueFromDD(countryDD, country_DD);
					
			checkBox.click();
			
			btnSub.click();
			
			//completeRegBtn.click();

		}

}
