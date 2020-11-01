package com.hrms.API.Final.steps;

import com.hrms.utils.APICommonMethods;
import com.hrms.utils.APIConstants;
import com.hrms.utils.APIPayloadCommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEmployees {
	RequestSpecification request;
	Response response;

	@Given("a request is prepared to create employees")
	public void a_request_is_prepared_to_create_employees() {
	}

	/**
	 * Using Scenario Outline and Examples keyword for data driven testing in
	 * feature file and createEmployeeRequest method from APICommonMethods passing
	 * the body via createEmployeePayloadMoreDynamic method from
	 * APIPayloadCommonMethods class with its parameters data from feature file
	 */
	@When("employee data provided is {string}, {string}, {string},{string},{string},{string},{string}")
	public void employee_data_provided_is(String employeeFirstName, String employeeLastName, String employeeMiddleName,
			String employeeGender, String employeeBirthday, String employeeJobStatus, String employeeJobTitle) {

		request = APICommonMethods.createEmployeeRequest(GenerateTokenSteps.token,
				APIPayloadCommonMethods.createEmployeePayloadMoreDynamic(employeeFirstName, employeeLastName,
						employeeMiddleName, employeeGender, employeeBirthday, employeeJobStatus, employeeJobTitle));
	}

	/** get the response from the POST request*/
	@Then("employees are created")
	public void employees_are_created() {

		response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);

		response.prettyPrint();

	}
}
