package com.framework.ecommerce.steps;


import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import com.framework.ecommerce.pages.SignUpPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUp {
	SignUpPage signup = new SignUpPage();
	
	
	@Given("^open url$")
	public void open_url()  {
	   signup.launchApplication();
	   }
	
	@Test
	@When("^Enter user email \"([^\"]*)\"$")
	public void enter_user_email(String userEmail)  {
	    signup.enterEmail(userEmail);
	}

	@Test
	@When("^Click next button$")
	public void click_next_button() {
	    signup.clickNextButton();
	    
	}

	@Test
	@Then("^verify Email field populate with \"([^\"]*)\"$")
	public void verify_Email_field_populate_with(String userEmail)  {
	    assertTrue("populate email mismatch", signup.isEmailPopulatedWithSameEmail(userEmail));
	    
	}

	@Test
	@Then("^Click continue$")
	public void click_continue() {
	    signup.clickContinue();
	    
	}

	@Test
	@Given("^Create an account age displays$")
	public void create_an_account_age_displays()  {
	    assertTrue("Create an account page not displays", signup.isCreateAccountPageDisplays());
	    
	}
	
	@Test
	@When("^Enter first name \"([^\"]*)\"$")
	public void enter_first_name(String fname)  {
	    signup.enterFirstName(fname);
	    
	}
	@Test
	@When("^Enter last name \"([^\"]*)\"$")
	public void enter_last_name(String lname)  {
	    signup.enterLastName(lname);
	    
	}
	@Test
	@When("^Enter phone \"([^\"]*)\"$")
	public void enter_phone(String phone)  {
	    signup.enterPhone(phone);
	    
	}
	@Test
	@When("^Enter password \"([^\"]*)\"$")
	public void enter_password(String password) {
	   signup.enterPassword(password);
	    
	}
	
	@Then("^Name fields error \"([^\"]*)\" displays$")
	public void name_fields_error_displays(String errorMessage)  {
	    assertTrue("Name fields error not displays",signup.isErrorMessageDisplays(errorMessage));
	}
	
	@Then("^Email fields error \"([^\"]*)\" displays$")
	public void email_fields_error_displays(String errorMessage)  {
		assertTrue("Email fields error not displays",signup.isErrorMessageDisplays(errorMessage));
	}

	@Then("^Phone fields error \"([^\"]*)\" displays$")
	public void phone_fields_error_displays(String errorMessage)  {
		assertTrue("Phone fields error not displays",signup.isErrorMessageDisplays(errorMessage));
	}

	@Then("^Password fields error \"([^\"]*)\" displays$")
	public void password_fields_error_displays(String errorMessage)  {
		assertTrue("Password fields error not displays",signup.isErrorMessageDisplays(errorMessage));
	}

}
