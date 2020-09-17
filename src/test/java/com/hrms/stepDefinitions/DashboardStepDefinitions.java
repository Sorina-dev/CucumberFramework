package com.hrms.stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class DashboardStepDefinitions extends CommonMethods{
	
	@Then("verify the following dashboard tabs")     //DataTable is a class from cucumber
	public void verify_the_following_dashboard_tabs(DataTable dashboardTabs) {
		
		//the expected tab names convert from Dashboard.feature file  to List<String>
		List<String> expectedDashTabs = dashboardTabs.asList(); //method from DataTable class
		
		//create a new List<String> in order to add there the following actual tab names
		List<String> actualDashTabs = new ArrayList<String>();
		
		// adding the actual tab names (WebElements converted into Strings) into the List<String>
		for (WebElement dashTab : dash.dashTabs) {
			actualDashTabs.add(dashTab.getText());
		}
		
		System.out.println(expectedDashTabs);
		System.out.println(actualDashTabs);
		
		//validate the tab names
		Assert.assertEquals(expectedDashTabs, actualDashTabs);
	}

	
// validation using nested for loop
	
//	for (int i = 0; i < expectedDashTabs.size(); i++) {
//		for (int n = 0; n < dashboard.dashTabs.size(); n++) {
//			if (expectedDashTabs.get(i).equals(dashboard.dashTabs.get(n).getText())) {
//				System.out.println("comparing like that");
//				break;
//			}
//		}
}