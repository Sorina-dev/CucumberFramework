package com.hrms.stepDefinitions;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	//hooks run no matter what happens if it fails the test or not
	//so we dont need the steps that are repeating in Login.feature file and methods that repeat the actions in LoginStepDefinition class

	
	@Before                                    //import from io.cucumber
	public void startTest() {
		BaseClass.setUp();                    //we made those methods static in order to access them from here
	}
	
	@After               // Scenario is an independent class
	public void endTest(Scenario scenario) {        //import cucumber.java
		
		// we want to take screenshot
		
		byte[] screenshot;                         //return an array of bytes, cuz pictures consists of bytes       
		if(scenario.isFailed()) {                 // Scenario class has methods isFailed()
			
			screenshot = CommonMethods.takeScreenshot("failed/"+ scenario.getName());    //failed/-->the folder in screenshots folder + the name and time stamp
		}else {
			screenshot = CommonMethods.takeScreenshot("passed/"+ scenario.getName());    //passed/--> folder
		}
		        //attach(byte[] data, String mediaType, String name)-->method from independent Scenario class
		scenario.attach(screenshot, "image/png", scenario.getName());
		                
		
		BaseClass.tearDown();
	}
}
