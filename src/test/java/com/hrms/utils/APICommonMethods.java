package com.hrms.utils;

import static io.restassured.RestAssured.given;

import com.hrms.API.Final.steps.GenerateTokenSteps;

import io.restassured.specification.RequestSpecification;

public class APICommonMethods {

	/** Use this method to create an employee */
	/**
	 * Pass below parameters
	 * 
	 * @param token
	 * @param createEmployeeBody
	 * @return
	 */
	// we need to make it static otherwise it will return null values and throw a
	// NullPointerException
	// its values are reassigned this way
	public static RequestSpecification createEmployeeRequest(String token, String createEmployeeBody) {
		return given().header("Authorization", token).header("Content-Type", "application/json")
				.body(createEmployeeBody);
//		 // instead of this :body( CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON) - that was already sent in create employee request 
	}

	/**
	 * Use this method to GET one Employee
	 * 
	 * @param token
	 * @param employeeID
	 * @return
	 */
	public static RequestSpecification getOneEmployeeRequest(String token, String employeeID) {

		return given().header("Content-Type", "application/json").header("Authorization", token).param("employee_id",
				employeeID);

	}
}
