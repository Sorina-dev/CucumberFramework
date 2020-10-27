package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobTitlesStepDefinitions extends CommonMethods{

	@When("navigate to Job Titles")
	public void navigate_to_Job_Titles() {
	    jsClick(dash.adminLinkBtn);
	    jsClick(dash.jonTitlesLinkBtn);
	}
	
	@When("get all Job Titles from table")
	public void get_all_Job_Titles_from_table() {
	    System.out.println(jobTitle.getJobTitlesFromTable());
	}
	
	@Then("validate the Job Titles from ui against db")
	public void validate_the_Job_Titles_from_ui_against_db() {
	    System.out.println("DB Job Titles List size is " + DBStepDefinitions.dbData.size());
	    System.out.println("UI Job Titles List sise is"+jobTitle.getJobTitlesFromTable());
	    Assert.assertEquals(DBStepDefinitions.dbData, jobTitle.getJobTitlesFromTable());
	}
}
