package com.hrms.stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchEmployeeStepDefinitions extends CommonMethods {
	@Then("go to the Employee List")
	public void go_to_the_Employee_List() {
		waitForVisibility(dash.pimLinkBtn);
		jsClick(dash.pimLinkBtn);
		waitForVisibility(dash.empListBtn);
		jsClick(dash.empListBtn);
	}

	@When("search by ID {string}")
	public void search_by_ID(String ID) {
		waitForVisibility(searchEmp.idField);
		waitForClickability(searchEmp.idField);
		try {
			Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		sendText(searchEmp.idField, ID);
	}
	
	@Then("click on search Button")
	public void click_on_search_Button() {
		waitForVisibility(searchEmp.searchBtn);
		click(searchEmp.searchBtn);
	}

	@Then("validate the user ID {string}")
	public void validate_the_user(String ID) {
		waitForVisibility(searchEmp.tableCellId);
		try {
			Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		String actualText = searchEmp.tableCellId.getText();
		
		System.out.println(actualText);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualText,ID);
        soft.assertAll();
	}
	
	
	@When("search by name {string}")
	public void search_by_name(String Name) {
		waitForVisibility(searchEmp.nameField);
		waitForClickability(searchEmp.nameField);
		try {
			Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		sendText(searchEmp.nameField, Name);
	}
	

	@Then("validate the user name {string}")
	public void validate_the_user_name(String Name) {
		waitForVisibility(searchEmp.tableCellName);
		waitForVisibility(searchEmp.tableCellLastname);
		String actualName = searchEmp.tableCellName.getText();
		String actualLastname = searchEmp.tableCellLastname.getText();
		String actualFullName = (actualName + " " + actualLastname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualFullName, Name);
        soft.assertAll();
		
	}

}
