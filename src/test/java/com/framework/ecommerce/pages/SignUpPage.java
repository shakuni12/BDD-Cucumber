package com.framework.ecommerce.pages;

import org.openqa.selenium.By;

import com.framework.ecommerce.utils.PropertyHelper;

public class SignUpPage extends BasePage{
	
	public By emailField = By.name("email");
	public By nextButton = By.xpath("//button[contains(.,'NEXT')]");
	public By continueButton = By.xpath("//span[contains(.,'Continue')]");
	public By createAccount = By.xpath("//h6[contains(.,'Create an account')]");
	public By firstName = By.name("first_name");
	public By lastName = By.name("last_name");
	public By phoneNumber = By.name("phone");
	public By password = By.name("password");
	public By robotCheck = By.xpath("//div[@class='recaptcha-checkbox-border']");
	public By signupButton = By.xpath("//button[contains(.,'Signup')]");
	public By welcomeToYocket = By.xpath("//h2[contains(.,'Welcome to Yocket')]");
	public String signUpPageError = "//div[contains(text(),'ERROR')]";
	
	public void launchApplication() {
		String url = PropertyHelper.getValue("url");
		get(url);
	}
	
	public void enterEmail(String email) {
		clear(emailField);
		sendText(emailField, email);
	}
	
	public void clickNextButton() {
		click(nextButton);
	}
	
	public boolean isEmailPopulatedWithSameEmail(String expectedEmail) {
		String actualEmail = getFieldValue(emailField);
		System.out.print(actualEmail);
		if(actualEmail.equals(expectedEmail)) {
			return true;
		}
		return false;
	}
	
	public void clickContinue() {
		click(continueButton);
	}
	
	public boolean isCreateAccountPageDisplays() {
		return isElementPresent(createAccount);
	}
	
	public void enterFirstName(String fname) {
		waitForVisibility(firstName);
		sendText(firstName, fname);
	}
	
	public void enterLastName(String lname) {
		sendText(lastName, lname);
	}
	
	public void enterPhone(String phone) {
		sendText(phoneNumber, phone);
	}
	
	public void enterPassword(String psswrd) {
		sendText(password, psswrd);
	}
	
	public boolean isErrorMessageDisplays(String error) {
		
		String locators=signUpPageError.toString().replace("ERROR", error);
		By xpath = locatorParser(locators);
		waitForVisibility(xpath);
		return isElementPresent(xpath);
	}
	
	
	
	
	

}
