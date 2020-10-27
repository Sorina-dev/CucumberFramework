package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ViewEmployeePageList extends BaseClass{
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement EmployeeListBtn;
	
	@FindBy(id = "empsearch_id")
	public WebElement idTextBox;
	
	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement employeeNameTextBox;
	@FindBy(id = "empsearch_id")
	public WebElement EmpIdTextBox;	
	
	@FindBy(id = "searchBtn")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr/td/a[1]")
	public WebElement idFOundTableResult;
	
	@FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr/td/[3]")
	public List<WebElement> firstNameFoundTableResult;
	
	@FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr/td/a)[3]")
	public WebElement lastNameFoundTableResult;
	
	@FindBy(xpath = "//input[starts-with(@id, 'ohrmList_chkSelectRec')])[1]")
	public WebElement firstCheckBox;
	
	@FindBy(xpath = "//table[@id = 'resultTable']")
	public WebElement resultTable;
	
	/** method to check if resultTable is displayed*/
	public boolean isTableDisplayed() {
		return resultTable.isDisplayed();
	}
	
	/** method to loop through each and every row to get the names */
	public List<Map<String, String>> getFirstNameFromTable(){    
		List<Map<String, String>> uiFirstNames = new ArrayList<>();
		//iterate through every row and retrieve the firstname
		for(WebElement firstNameRow :firstNameFoundTableResult) {
			//initialize the map
			Map<String, String> mapData = new LinkedHashMap<>();
			//get the text from every row data
			String tableName = firstNameRow.getText();
			//store the data in the mapData; key--> the column name from mysqlworkbench; value -> text stored in tableName 
			mapData.put("emp_firstname", tableName);
			//add the maps in list
			uiFirstNames.add(mapData);
		}
		return uiFirstNames;
	}
	
	
	@FindBy(css = "input.delete")
	public WebElement deleteBtn;
	
	@FindBy(css = "input#dialogDeleteBtn")
	public WebElement confirmDeleteBtn;
	
	@FindBy(xpath = "//td[text()='No Record Found']")
	public WebElement noRecordMessage;
	
	@FindBy(xpath = "//td[@class=\"left\"][1]")
	public WebElement empIdLink;
	
	public ViewEmployeePageList() {
		PageFactory.initElements(driver, this);
	}

}
