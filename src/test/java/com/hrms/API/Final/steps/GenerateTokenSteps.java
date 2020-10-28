package com.hrms.API.Final.steps;

import static io.restassured.RestAssured.*;

import com.hrms.utils.APIConstants;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenerateTokenSteps {

//	String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api"; //  http://
	static String token;

	@Given("a JWT id generated")
	public void a_JWT_id_generated() {
		// if there is time stamp need to delete it, or insert it each time in email to
		// get the exact data
		/**
		 * Preparing request to generate token; a new token will be created every single
		 * time this given() runs in the background of each scenario
		 */
		RequestSpecification generateTokenRequest = given().header("Content-Type", "application/json")
				.body("{\r\n" + "  \"name\": \"Pioneers\",\r\n" + "  \"email\": \"Pioneers_@json.com\",\r\n"
						+ "  \"password\": \"ThePioneers__\"\r\n" + "}");

		/** Storing response into generateTokenResponse */
		Response generateTokenResponse = generateTokenRequest.when().post(APIConstants.GENERATE_TOKEN_URI); // "/generateToken.php"

		/** Optional to print response */
		generateTokenResponse.prettyPrint();

		/**
		 * Storing token as a static global variable that will be used for other calls
		 */
		token = "Bearer " + generateTokenResponse.jsonPath().getString("token");

	}
}
