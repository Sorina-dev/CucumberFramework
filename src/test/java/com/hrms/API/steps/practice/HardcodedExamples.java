package com.hrms.API.steps.practice;

import org.junit.FixMethodOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import io.restassured.RestAssured; //from here the static packages imported manually
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*; // import it manually
import static org.hamcrest.Matchers.*; //import it manually

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // import org.junit.FixMethodOrder; this MANUALLY IMPORT is for the Tests
												// to run in alphabetical order

public class HardcodedExamples {
	/*
	 * REST Assured - Java library specifically developed to automate REST endpoints
	 * 
	 * Given - Preparing your request; When - What action will you perform, what
	 * type of call are you making?; Then - Verification
	 */

	/** BaseURI for all endpoints */ // concatenates automatically the base URI and the endpoints at the execution
	String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api"; // base URI -its base is URL, we must
																					// add - http://

	/** JWT, generate a new token and take it from globals */
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDM3Mzc3MDIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYwMzc4MDkwMiwidXNlcklkIjoiMjEwOCJ9.w10lV4crrqE5pBlkODLP79TIp84Jm8ZGL8izutktPnM";
	static String employeeID;

	@Test // if we want not to run -- comment out the // @Test
	public void aasampleTest() {

		/**
		 * Preparing request for /getOneEmployee.php given() method comes from static
		 * io.restassured.RestAssured* package - NEED TO IMPORT IT MANUALLY import 
		 * Using .log.all to print out everything being sent with the request
		 */ // employee_id is the key in the Params in Postman
		RequestSpecification preparingGetOneEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json").queryParam("employee_id", "27282A").log().all();

		/** Making call to /getOneEmployee.php */ // needed the endpoint // import io.restassured.response.Response;
		Response getOneEmployeeResponse = preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");

		/** One way to print response Object */
		// System.out.println(getOneEmployeeResponse.asString());
		// if not converted as a String it will print the object and its package

		/** Second way using rest assured prettyPrint() */
		// getOneEmployeeResponse.prettyPrint(); // will print in a readable format way

		/** Using assertThat() to verify status code */
		getOneEmployeeResponse.then().assertThat().statusCode(200);
	}

	@Test
	public void aPOSTcreateEmployee() { // a letter to run in alphabetical order

		/** Preparing request for creating an employee */
		RequestSpecification createEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json")
				.body("{\r\n" + "  \"emp_firstname\": \"Sorina\",\r\n" + "  \"emp_lastname\": \"Cristian\",\r\n"
						+ "  \"emp_middle_name\": \"B\",\r\n" + "  \"emp_gender\": \"F\",\r\n"
						+ "  \"emp_birthday\": \"1987-01-20\",\r\n"
						+ "  \"emp_status\": \"Independent contractor\",\r\n"
						+ "  \"emp_job_title\": \"Cloud Architect\"\r\n" + "}");

		/** making call to /createEmployee.php */ // log.all has to be before the call if we want to use it or in
													// given()
		Response createEmployeeResponse = createEmployeeRequest.when().log().all().post("/createEmployee.php");

		/** Printing response */
		// createEmployeeResponse.prettyPrint();

		/**
		 * Using JsonPath() to view the response body which lets us get the employee ID
		 * We are storing the employeeID as a global variable to be able to use with
		 * other calls
		 */
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id"); // traversing from the body
																								// respose

		/** Optional: printing employeeID */
		System.out.println(employeeID);

		/** Verifying status code is 201 */
		createEmployeeResponse.then().assertThat().statusCode(201);

		/**
		 * Verifying response body "Message" is paired with "Entry Created"; equalTo()
		 * method comes from static Hamcrest package - NEED TO IMPORT IT MANUALLY import
		 * static org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created")); // import static
																								// org.hamcrest.Matchers.*;

		/** Verifying created employee first name */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Sorina"));

		/** Verifying the server from the headers is Apache/2.4.39 (Win64) PHP/7.2.18 */
		createEmployeeResponse.then().header("Server", equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));

	}

	@Test
	public void bGETcreatedEmployee() {

		/** Preparing request to get created employee */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID);

		/** Storing response for retrieving created employee */
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");

		/** Printing response */
		// getCreatedEmployeeResponse.prettyPrint();

		/** Storing employee ID into empID to compare with static global employeeID */
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");

		/** Comparing empID with stored employeeID from created employee call */
		boolean verifyingEmployeeID = empID.equalsIgnoreCase(employeeID);

		/** Asserting to verify the above condition is true */
		Assert.assertTrue(verifyingEmployeeID); // import org.junit.Assert;

		/** Verifying status code is 200 */
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);

		/**
		 * Storing full response as a string so that we are able to pass it as an
		 * argument with JsonPath
		 */
		String response = getCreatedEmployeeResponse.asString();

		// String empID =
		// getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		// --> instead of this we create JsonPath class to get other variables from the
		// response
		/** Created object of JsonPath */
		JsonPath js = new JsonPath(response); // its a class

		/** Grabbing body details and store it in string variables using 'js' */
		String employeeID = js.getString("employee[0].employee_id");
		String employeeFirstname = js.getString("employee[0].emp_firstname");
		String employeeLastname = js.getString("employee[0].emp_lastname");
		String employeeMiddlename = js.getString("employee[0].emp_middle_name");
		String employeeDOB = js.getString("employee[0].emp_birthday");
		String employeeGender = js.getString("employee[0].emp_gender");
		String employeeJobtitle = js.getString("employee[0].emp_job_title");
		String employeeStatus = js.getString("employee[0].emp_status");

		/** Asserting response employee ID matches stored employee ID */
		Assert.assertTrue(employeeID.contentEquals(employeeID));

		/** Asserting the rest of the values match expected data */
		Assert.assertEquals(employeeFirstname, "Sorina");
		Assert.assertEquals(employeeLastname, "Cristian");
		Assert.assertEquals(employeeMiddlename, "B");
		Assert.assertEquals(employeeDOB, "1987-01-20");
		Assert.assertEquals(employeeGender, "Female");
		Assert.assertEquals(employeeJobtitle, "Cloud Architect");
		Assert.assertEquals(employeeStatus, "Independent contractor");

	}
	/*
	 * need to run all tests, otherwise is displayed the mesaage: "Error":
	 * "Please fill all inputs" because after execution it is equal to null and
	 * always generate the token and put it here
	 */

//	@Test
	public void cGETallEmployees() {

		/** Preparing request to get all employees */
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);

		/** Storing response into getAllEmployeesResponse */
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

		/** printing response */
		// getAllEmployeesResponse.prettyPrint();

		/** Storing response as a String */
		String response = getAllEmployeesResponse.asString();

		/**
		 * Created object of JsonPath and passing response as a String as an argument
		 */
		JsonPath js = new JsonPath(response);

		/** Retrieving the size of the array (number of the object in the array) */
		int count = js.getInt("Employees.size()");
		// System.out.println(count);

		/** Using for loop to retrieve all the employee_id's from the response */
		for (int i = 0; i < count; i++) {

			String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id");

//			//System.out.println(allEmployeeIDs);

			/**
			 * Using conditional IF to retrieve emp_firstname if there is that certain
			 * employee ID
			 */
			if (allEmployeeIDs.contentEquals(employeeID)) {

				System.out.println("Employee ID: " + employeeID + " is present in the body");
				String firstNameOfEmpID = js.getString("Employees[" + i + "].emp_firstname");
				// System.out.println(firstNameOfEmpID);
				break;
			}
		}
		/** Using for loop to print out first names of all employees */
		for (int i = 0; i < count; i++) {
			String allFirstNames = js.getString("Employees[" + i + "].emp_firstname");
			// System.out.println(allFirstNames);
		}
	}

	@Test
	public void dPUTupdateCreatedEmployee() {

		RequestSpecification putUpdateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body("{\r\n" + "  \"employee_id\": \"" + employeeID + "\",\r\n" + // pay
																													// attention
																													// at
																													// quotations
						"  \"emp_firstname\": \"Meryemm\",\r\n" + "  \"emp_lastname\": \"AKCAY\",\r\n"
						+ "  \"emp_middle_name\": \" \",\r\n" + "  \"emp_gender\": \"F\",\r\n"
						+ "  \"emp_birthday\": \"1993-02-16\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
						+ "  \"emp_job_title\": \"Cloud Architect\"\r\n" + "}")
				.log().all();
		/** Storing request into putUpdateCreatedEmployeeResponse Response */
		Response putUpdateCreatedEmployeeResponse = putUpdateCreatedEmployeeRequest.when().put("/updateEmployee.php");

		/** Printing response */
		putUpdateCreatedEmployeeResponse.prettyPrint();

		/** Storing response as a String */
		String response = putUpdateCreatedEmployeeResponse.asString();

		/** Creating JsonPath object */
		JsonPath js = new JsonPath(response);

		/** Storing employee details into String variables using 'js' */
		String employeeId = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[0].emp_firstname");
		String middleName = js.getString("employee[0].emp_middle_name");
		String lastName = js.getString("employee[0].emp_lastname");
		String birthday = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		String jobTitle = js.getString("employee[0].emp_job_title");
		String status = js.getString("employee[0].emp_status");

		/** Asserting the rest of the values match expected data */
		Assert.assertTrue(employeeId.contentEquals(employeeID));
		Assert.assertEquals(firstName, "Meryemm");
		Assert.assertEquals(middleName, " ");
		Assert.assertEquals(lastName, "AKCAY");
		Assert.assertEquals(birthday, "1993-02-16");
		Assert.assertEquals(gender, "Female");
		Assert.assertEquals(status, "Employee");
		Assert.assertEquals(jobTitle, "Cloud Architect");

	}
}