package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//annotation(tool.class)
//annotation to set the options in order to run

@RunWith(Cucumber.class) 
@CucumberOptions(features = "src\\test\\resources\\features\\Login.feature",//need to give a path for our feature files
              //forward slash instead dots
		glue = "com/hrms/stepDefinitions", // we need to glue our step definitions 
		dryRun = false, //by default its false	//with dryRun if its true its gonna show the snippet we have to implement if we change a step in features file							
		monochrome = true,// when set as true will format the console outcome, it changes unrecognized characters from console output into numbers
		tags= "@smoke", // use tags to run only one or some scenarios
		strict = false, //if set on true it will fail the test if there is one unimplemented method and show the snippet
		plugin = {"pretty",  //will print all steps inside the console
				"html:target/cucumber-default-reports",//refresh the project and see in target folder , we need index.html  it generates html report
				"rerun:target/FailedTests.txt", //generates txt file only with failed tests
				"json:target/cucumber.json"}) //generates json report with all steps and passed or failed result
public class TestRunner {
//will run as JUnit
}





//NOTE:have to change the spanmessage element in loginpagelements