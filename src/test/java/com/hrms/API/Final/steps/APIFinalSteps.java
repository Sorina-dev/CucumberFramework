package com.hrms.API.Final.steps;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import com.hrms.utils.APIConstants;
import com.hrms.utils.APIPayloadCommonMethods;
import com.hrms.utils.CommonMethods;

public class APIFinalSteps {

	RequestSpecification request;
	Response response;
//	String BaseURI = RestAssured.baseURI= "http://18.232.148.34/syntaxapi/api";
	static String employeeID;
	

	@Given("a request is prepared to create an employee")
	public void a_request_is_prepared_to_create_an_employee() {

	//	request = given().header("Content-Type", "application/json").header("Authorization", GenerateTokenSteps.token)
	//			.body(APIPayloadCommonMethods.createEmployeePayload()).log().all();

		request = given().header("Authorization", GenerateTokenSteps.token).header("Content-Type", "application/json")
				.body(CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON)); // for body --> "/src/test/resources/JSONFiles/createEmployee.json"
	}
	
	

	@When("a POST call is made to create an employee")
	public void a_POST_call_is_made_to_create_an_employee() {

		response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI); // "/createEmployee.php"

	}

	@Then("the status code for creating an employee {int}")
	public void the_status_code_for_creating_an_employee(int statusCode) { // 201

		response.then().assertThat().statusCode(statusCode);
	}

	@Then("the employee is created contains key {string} and value {string}")
	public void the_employee_is_created_contains_key_and_value(String key, String value) { // "Message"; "Entry Created"
		response.then().assertThat().body(key, equalTo(value));
	}

	@Then("the employee ID {string} is stored as a global variable to be used for other calls")
	public void the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(String value) {

		employeeID = response.jsonPath().getString(value);
	}

	@Given("a request is prepared to retrieve the created employee")
	public void a_request_is_prepared_to_retrieve_the_created_employee() {

	}

	@When("a GET call is made to retrieve the created employee")
	public void a_GET_call_is_made_to_retrieve_the_created_employee() {

	}

	@Then("the status code for retrieving the created employee is {int}")
	public void the_status_code_for_retrieving_the_created_employee_is(Integer int1) {

	}

	@Then("the retrieved employee ID matches the globally stored employee ID")
	public void the_retrieved_employee_ID_matches_the_globally_stored_employee_ID() {

	}

	@Then("the retrieve data matches the data used to create an employee")
	public void the_retrieve_data_matches_the_data_used_to_create_an_employee() {

	}

	@Given("a request is prepared to retrieve all employees")
	public void a_request_is_prepared_to_retrieve_all_employees() {

	}

	@When("a GET call is made to retrieve all employees")
	public void a_GET_call_is_made_to_retrieve_all_employees() {

	}

	@Then("the status code for retrieving all employees is {int}")
	public void the_status_code_for_retrieving_all_employees_is(Integer int1) {

	}

	@Then("the retrieve data contains the globally stored employee ID")
	public void the_retrieve_data_contains_the_globally_stored_employee_ID() {

	}

	@Then("the retrieve data matches the data that was used to create an employee")
	public void the_retrieve_data_matches_the_data_that_was_used_to_create_an_employee() {

	}

}
