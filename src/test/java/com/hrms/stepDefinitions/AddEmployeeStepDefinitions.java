package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeStepDefinitions extends CommonMethods {

	@Given("log in")
	public void log_in() {
		sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.btnLogin);

	}

	@Given("go to Add Employee Page")
	public void go_to_Add_Employee_Page() {
		click(dash.pimLinkBtn);
		waitForVisibility(dash.addEmployeeBtn);
		click(dash.addEmployeeBtn);
	}

	@When("input the employee Full Name")
	public void input_the_employee_Full_Name() {
		waitForVisibility(addEmp.firstNameField);
		sendText(addEmp.firstNameField, "Marin");
		waitForVisibility(addEmp.middleNameField);
		sendText(addEmp.middleNameField, "M");
		waitForVisibility(addEmp.lastNameField);
		sendText(addEmp.lastNameField, "Stegarescu");
		click(addEmp.saveButton);
	}

	@Then("verify the Personal Details text")
	public void verify_the_Personal_Details_text() {

		String firstName = "Marin";
		String middleName = "M";
		String lastName = "Stegarescu";
		waitForVisibility(persDetails.progilePicText);
		Assert.assertEquals(persDetails.progilePicText.getText(), firstName + " " + middleName + " " + lastName);
	}

	@When("input the employee login details")
	public void input_the_employee_login_details() {
		waitForVisibility(addEmp.firstNameField);
		sendText(addEmp.firstNameField, "Alexa");
		waitForVisibility(addEmp.middleNameField);
		sendText(addEmp.middleNameField, "C");
		waitForVisibility(addEmp.lastNameField);
		sendText(addEmp.lastNameField, "Benefacio");
		click(addEmp.createLoginDetailsCheckbox);
		sendText(addEmp.userName, "Alexa156");
		sendText(addEmp.userPassword, "Djerg25$%*#@");
		sendText(addEmp.confirmPassword, "Djerg25$%*#@");
		click(addEmp.saveButton);
	}
	
	@Then("verify the Personal Details text after login details")
	public void verify_the_Personal_Details_text_after_login_details() {
		String firstName = "Alexa";
		String middleName = "C";
		String lastName = "Benefacio";
		waitForVisibility(persDetails.progilePicText);
		Assert.assertEquals(persDetails.progilePicText.getText(), firstName + " " + middleName + " " + lastName);
	}

	//PARAMETERIZATION
	
	@When("enter first name as {string} middle name as {string} and last name as {string}")
	public void enter_first_name_as_middle_name_as_and_last_name_as(String firstName, String middleName,
			String lastName) {
		sendText(addEmp.firstNameField, firstName);
		sendText(addEmp.middleNameField, middleName);
		sendText(addEmp.lastNameField, lastName);
	}
	
	@Then("verify that {string} is added successfully")
	public void verify_that_is_added_successfully(String fullName) {
		String profileName = persDetails.progilePicText.getText();
		Assert.assertEquals(fullName, profileName);
	}
	
	//Data Driven testing, when you do the same function using different data
	
	@When("enter employee {string}, {string} and {string}")
	public void enter_employee_and(String firstName, String middleName, String lastName) {
		sendText(addEmp.firstNameField, firstName);
		sendText(addEmp.middleNameField, middleName);
		sendText(addEmp.lastNameField, lastName);
	}

	@Then("click on save Button")
	public void click_on_save_Button() {
		click(addEmp.saveButton);
	}

	@Then("verify that {string}, {string} and {string} is successfully added")
	public void verify_that_and_is_successfully_added(String firstName, String middleName, String lastName) {
		String fullName = firstName + " " + middleName + " " + lastName;
		String fullProfileName = persDetails.progilePicText.getText();
		Assert.assertEquals(fullName, fullProfileName);
	}

	}

