package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features = "@target\\FailedTests.txt",//the path for failed test
              
		glue = "com/hrms/stepDefinitions", //don't need dryRun 
		monochrome = true, // don't need the tags cuz we get them from FailedTest.txt 
		plugin = {"pretty",  //don't need strict 
				"html:target/cucumber-default-reports",
				"rerun:target/FailedTests.txt"}  //don't need json 
        ) 
public class FailedRunner {

}
