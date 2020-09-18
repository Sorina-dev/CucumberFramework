package com.hrms.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
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
	

	@When("add multiple employees and verify they are added")   //import io.cucumber.datatable.DataTable;
	public void add_multiple_employees_and_verify_they_are_added(DataTable employees) throws InterruptedException {
		List<Map<String, String>>employeeNames = employees.asMaps();//cuz it have headers and data/ values and keys in feature file
		//adding employees via Scenario outline with headers
		for (Map<String, String> employeeName : employeeNames) {
			String firstName = employeeName.get("First Name"); //get the values
			String middleName = employeeName.get("Middle Name");
			String lastName = employeeName.get("Last Name");
			String empId = employeeName.get("Employee ID");
			
			sendText(addEmp.firstNameField, firstName);
			sendText(addEmp.middleNameField, middleName);
			sendText(addEmp.lastNameField, lastName);
			sendText(addEmp.empID, empId);
			
			click(addEmp.saveButton);
			
			String actualName = persDetails.progilePicText.getText();
			String expectedName = firstName + " " + middleName + " " + lastName;
			Assert.assertEquals("Verifying employee names", expectedName, actualName);
			click(dash.addEmployeeBtn);
			Thread.sleep(1000);
		}
	}
	
	@When("add multiple employees from {string} verify they are added successfully")
	public void add_multiple_employees_from_verify_they_are_added_successfully(String sheetName) throws InterruptedException {
		List<Map<String, String>> excelData = ExcelUtility.excelToListMap(Constants.TESTDATA_FILEPATH, sheetName);//static excelToListMap() from ExcelUtility class
		//with the parameters the sheetname and the file path 
		for (Map<String, String> excelEmpName : excelData) {
			String firstName = excelEmpName.get("FirstName");
			String middleName = excelEmpName.get("MiddleName");
			String lastName = excelEmpName.get("LastName");
			String empId = excelEmpName.get("Employee ID");
			
			sendText(addEmp.firstNameField, firstName);
			sendText(addEmp.middleNameField, middleName);
			sendText(addEmp.lastNameField, lastName);
			sendText(addEmp.empID, empId);
			
			click(addEmp.saveButton);
			
			String actualName = persDetails.progilePicText.getText();
			String expectedName = firstName + " " + middleName + " " + lastName;
			Assert.assertEquals("Verifying employee names", expectedName, actualName);
			jsClick(dash.addEmployeeBtn);
			Thread.sleep(1000);
		}
	}


	}

