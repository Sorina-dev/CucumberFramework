package com.hrms.API.Final.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.entity.ContentType;
import org.junit.Assert;

import com.hrms.utils.APICommonMethods;
import com.hrms.utils.APIConstants;
import com.hrms.utils.CommonMethods;

public class APIFinalSteps extends CommonMethods {

	RequestSpecification request;
	Response response;
//	String BaseURI = RestAssured.baseURI= "http://18.232.148.34/syntaxapi/api";
	static String employeeID;

	@Given("a request is prepared to create an employee")
	public void a_request_is_prepared_to_create_an_employee() {
//       /** First way to send payload*/
//	//	request = given().header("Content-Type", "application/json").header("Authorization", GenerateTokenSteps.token)
//	//			.body(APIPayloadCommonMethods.createEmployeePayload()).log().all();

//		----------------------------------------------------------------
//		/** 2nd way to send payload*/
//		request = given().header("Authorization", GenerateTokenSteps.token).header("Content-Type", "application/json")
//				.body(CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON)); // for body --> "/src/test/resources/JSONFiles/createEmployee.json"
//		
//      ---------------------------------------------------------------		
//		/** Third way is to hardcode */
//		
//      ---------------------------------------------------------------
		/**
		 * Using createEmployeeRequest() common method which creates a request by
		 * passing expected parameters
		 */
		request = APICommonMethods.createEmployeeRequest(GenerateTokenSteps.token,
				CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON));

//      --------------------------------------------------------------
		/**
		 * The payload MUST be a String! Below line of code is doing the same as above
		 */
//		request = APICommonMethods.createEmployeeRequest(GenerateTokenSteps.token,APIPayloadCommonMethods.createEmployeeBody());
	}

	@When("a POST call is made to create an employee")
	public void a_POST_call_is_made_to_create_an_employee() {

		/**
		 * storing the response by posting the constant with value "/createEmployee.php"
		 * from APIConstants class
		 */
		response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
	}

	@Then("the status code for creating an employee {int}")
	public void the_status_code_for_creating_an_employee(int statusCode) {

		/**
		 * asserting the status code with value "201" as parameter from the feature file
		 * from the response
		 */
		response.then().assertThat().statusCode(statusCode);
	}

	@Then("the employee is created contains key {string} and value {string}")
	public void the_employee_is_created_contains_key_and_value(String key, String value) { //

		/**
		 * asserting the values "Message"; "Entry Created" sent as parameters in feature
		 * file from the response body
		 */
		response.then().assertThat().body(key, equalTo(value));
	}

	@Then("the employee ID {string} is stored as a global variable to be used for other calls")
	public void the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(String value) {

		employeeID = response.jsonPath().getString(value);
	}

	@Given("a request is prepared to retrieve the created employee")
	public void a_request_is_prepared_to_retrieve_the_created_employee() {
		/** 1st way */
//	//	request = given().header("Content-Type", "application/json").header("Authorization", GenerateTokenSteps.token).param("employee_id", employeeID );
//   -------------------------------------------------------------------------------------

		/** 2nd way */
//	//request =	given().header("Content-Type", ContentType.APPLICATION_JSON).header("Authorization", GenerateTokenSteps.token).param("employee_id", employeeID);
//		//import org.apache.http.entity.ContentType;   APPLICATION_JSON is an enum - constant of the restassured library
// ------------------------------------------------------------------------------------------
		/**
		 * 3rd way call the method getOneEmployeeRequest() from the APICommonMethods and
		 * pass the parameters = token from GenerateTokenSteps, and employeeID and store
		 * the RequestSpecification in variable 'request' by reassigning it (that's why
		 * we don't make it static)
		 */

		request = APICommonMethods.getOneEmployeeRequest(GenerateTokenSteps.token, employeeID);
	}

	@When("a GET call is made to retrieve the created employee")
	public void a_GET_call_is_made_to_retrieve_the_created_employee() {

		/**
		 * get the created employee from the request and store it in 'response'
		 * variable. by sending the constant GET_ONE_EMPLOYEE_URI with value
		 * "/getOneEmployee.php" from the APIConstants
		 */
		response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
	}

	@Then("the status code for retrieving the created employee is {int}")
	public void the_status_code_for_retrieving_the_created_employee_is(int statusCodeForRetrievingEmployee) {

		/**
		 * asserting the status code with value "200" as parameter from the feature file
		 * from the response
		 */
		response.then().assertThat().statusCode(statusCodeForRetrievingEmployee);
	}

	@Then("the retrieved employee ID {string} matches the globally stored employee ID")
	public void the_retrieved_employee_ID_matches_the_globally_stored_employee_ID(String retrieveEmployeeID) {

		/**
		 * the retrieved employee id from the response body passed in feature file as
		 * "employee[0].employee_id" is equal to global employeeID
		 */
		response.then().assertThat().body(retrieveEmployeeID, equalTo(employeeID));
	}

	@Then("the retrieved data at {string} matches the data used to create an employee with employee ID {string}")
	public void the_retrieved_data_at_matches_the_data_used_to_create_an_employee_with_employee_ID(
			String employeeObject, String responseEmployeeID, DataTable dataTable) {

		/**
		 * We are validating expected data that we stored in feature file against actual
		 * data that we are retrieving from the response We are retrieving the response
		 * body by calling the object in feature file
		 */
		/** Retrieving expected data from feature file */
		List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class); 
		//there any other version of doing String.class, we could do it the way we learned it is for the old version of java

		/**
		 * Retrieving actual data from response object in feature file and its value in
		 * Postman
		 */
		List<Map<String, String>> actualData = response.body().jsonPath().get(employeeObject); // employee[0]...in
																								// Postman response body

		/** Starting at index 0 so we can iterate by one after each run */
		int index = 0;
		/** Enhanced loop to iterate through expectedData and store in variable 'map' */
		for (Map<String, String> map : expectedData) {
			/** get the keys contained of the map and store in Set of keys */
			Set<String> keys = map.keySet();
			/** looping through keys */
			for (String key : keys) {
				/** get the value of each key and store it in variable 'expectedValue' */
				String expectedValue = map.get(key);
				/** get the index and the value of the key from the list of Maps */
				String actualValue = actualData.get(index).get(key); // [0].employee_firstname ...in Postman response
																		// body
				/** asserting the expected and actual values */
				Assert.assertEquals(expectedValue, actualValue);
			}
			index++;
		}
		/**
		 * convert as String the argument sent in feature file "employee[0].employee_id"
		 * as 'responseEmployeeID' parameter in this step and store it in 'empID'
		 * variable assertion of the actual and expected value of employeeID
		 */
		String empID = response.body().jsonPath().getString(responseEmployeeID);
		Assert.assertTrue(empID.contentEquals(employeeID));
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
