package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends CommonMethods {
	@Given("go to HRMS login page")                 //precondition
	public void go_to_hrms_login_page() {
	    setUp();
	}

	@When("login with valid credentials")           //action
	public void login_with_valid_credentials() {
		//sendText() from CommonMethods class with parameters usernametextbox from login page; the value of the key username
		//from Configuration.properties file called with the getPropeValue() from ConfigsReader class(utils)
	   sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
	   sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
	   click(login.btnLogin);
	}

	@Then("verify the dashboard logo is displayed")  //result
	public void verify_the_dashboard_logo_is_displayed() {
		//hard assertion of the welcome element from dashboard class inintialized in PageInitilaizer class
	   Assert.assertTrue(dash.welcome.isDisplayed());  //import from org.junit
	}

	@Then("quit the browser")                       //And keyword => continuation of the result
	public void quit_the_browser() {
	    tearDown();
	}
	
	@When("login with invalid credentials")         //Given and And are repeated in feature file so they are not shown anymore as snippets
	public void login_with_invalid_credentials() {
		// calling the loginToHrms() from LoginPageElements class and pass the parameters fro username and password
	    login.loginToHrms("Admihbdc", "Syntash");
	}

	@Then("verify the error message")
	public void verify_the_error_message() {
	    Assert.assertTrue(login.spanMessage.isDisplayed());
	}
	
	@When("login with empty username")
	public void login_with_empty_username() {
	   login.loginToHrms("", ConfigsReader.getPropValue("password"));
	}
	
	@When("login with empty password")
	public void login_with_empty_password() {
	   login.loginToHrms(ConfigsReader.getPropValue("username"), "");
	}
	
}
