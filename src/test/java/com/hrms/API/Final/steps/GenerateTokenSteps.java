package com.hrms.API.Final.steps;
import static io.restassured.RestAssured.*;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenerateTokenSteps {

	String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api"; //  http://
	static String token;
	
	@Given("a JWT id generated")
	public void a_JWT_id_generated() {
		
		/** Preparing request to generate token */
		RequestSpecification generateTokenRequest=given().header("Content-Type", "application/json").body("{\r\n" + 
				"  \"name\": \"Pioneers\",\r\n" + 
				"  \"email\": \"Pioneers_1603738829@json.com\",\r\n" +               //take the timeStamp when send the create user
				"  \"password\": \"ThePioneers__\"\r\n" +                            // in the response body
				"}");
		
		/** Storing response into generateTokenResponse*/
		Response generateTokenResponse = generateTokenRequest.when().post("/generateToken.php");
		
		/** Optional to print response */
		generateTokenResponse.prettyPrint();
		
		/** Storing token as a static global variable that will be used for other calls */
		token = "Bearer "+ generateTokenResponse.jsonPath().getString("token");
		
	}
}
