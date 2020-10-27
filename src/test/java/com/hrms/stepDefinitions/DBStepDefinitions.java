package com.hrms.stepDefinitions;

import java.util.List;
import java.util.Map;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.DBUtils;
import com.hrms.utils.GlobalVariables;

import io.cucumber.java.en.Then;

public class DBStepDefinitions extends CommonMethods {

	static List<Map<String, String>> dbData;
	
	@Then("get first name from DB")
	public void get_first_name_from_DB() {

		// storing the query into a string variable
		// anytime the employee ID is different it will change the empID global variable too
		String sqlQuery = "select emp_firstname from hs_hr_employees where employee_id = " + GlobalVariables.empID;

		/**
		 * calling the method storeDataFromBD() from DBUtils class in com.hrms.utils
		 * package to retreive the data from DB and store it into List of Maps. We make
		 * it global so other methods can refer to it
		 */
		dbData = DBUtils.storeDataFromBD(sqlQuery);
		DBUtils.closeConnection();
	}
	
	@Then("get all Job Titles from db")
	public void get_all_Job_Titles_from_db() {
	    
		String sqlQuery = "select job_titles from ohrm_job_title order by job_title";
		
		dbData = DBUtils.storeDataFromBD(sqlQuery);
		DBUtils.closeConnection();
	}

}
