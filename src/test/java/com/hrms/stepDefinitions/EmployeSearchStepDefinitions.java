package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.GlobalVariables;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EmployeSearchStepDefinitions extends CommonMethods{
	@When("navigate to employee list")
	public void navigate_to_employee_list() {
	   click(dash.pimLinkBtn);
	  click(viewEmp.EmployeeListBtn);
	}

	@When("enter a valid Employee id {string}")
	public void enter_a_valid_Employee_id(String employeeId) {
	 sendText(viewEmp.idTextBox, employeeId);
	 
	 /** anytime the employeeId changes, the global variable changes too*/
	 GlobalVariables.empID = employeeId;
	}

	@Then("click on search button")
	public void click_on_search_button() {
	    click(viewEmp.searchBtn);
	}

	@Then("verify the table is displayed")
	public void verify_the_table_is_displayed() {
	    Assert.assertTrue(viewEmp.isTableDisplayed()); //import org.junit.Assert;
	}

	@When("get first name from the table")
	public void get_first_name_from_the_table() {
	    System.out.println(viewEmp.getFirstNameFromTable());
	}

	@Then("validate first names from UI against DB")
	public void validate_first_names_from_UI_against_DB() {
		                    //expected from DB             //actual from UI
	    Assert.assertEquals(DBStepDefinitions.dbData, viewEmp.getFirstNameFromTable());
	}

}
