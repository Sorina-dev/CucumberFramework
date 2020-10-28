package com.hrms.utils;

import org.json.JSONObject;

public class APIPayloadCommonMethods {

	/**
	 * this method returns as string the created employee body. WE CAN USE ONE OF THIS METHODS, CUZ IT ARE THE SAME
	 * Here the body is copy pasted from Postman create employee call, body
	 * @return
	 */
	public static String createEmployeeBody() {   

		String createEmployeeBody = "{\r\n" + 
				"  \"emp_firstname\": \"Sorina\",\r\n" + 
				"  \"emp_lastname\": \"Cristian\",\r\n" + 
				"  \"emp_middle_name\": \"B\",\r\n" + 
				"  \"emp_gender\": \"F\",\r\n" + 
				"  \"emp_birthday\": \"1987-01-20\",\r\n" + 
				"  \"emp_status\": \"Independent contractor\",\r\n" + 
				"  \"emp_job_title\": \"Cloud Architect\"\r\n" + 
				"}";
		return createEmployeeBody;
	}
	
	
	/**
	 * this method returns as string the created employee body.
	 * Here it is created an object of JSONObject class
	 * and all body details are sent as keys and values
	 * @return
	 */
	public static String createEmployeePayload() {
		
		JSONObject obj = new JSONObject();
		
		obj.put("emp_firstname", "Sorina");
		obj.put("emp_lastname", "Cristian");
		obj.put("emp_middle_name", "B");
		obj.put("emp_gender", "F");
		obj.put("emp_birthday", "1987-01-20");
		obj.put("emp_status", "Independent contractor");
		obj.put("emp_job_title", "Cloud Architect");
		
		
		return obj.toString();
		
	}
	
}
