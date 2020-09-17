package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class SearchEmployeeListPageElements extends BaseClass {
	


	@FindBy(css="input#empsearch_employee_name_empName")
	public WebElement nameField;
	
	@FindBy(css="input#empsearch_id")
	public WebElement idField;
	
	@FindBy(css="input#searchBtn")
	public WebElement searchBtn;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[2]")
	public WebElement tableCellId;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[3]")
	public WebElement tableCellName;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[4]")
	public WebElement tableCellLastname;
	
	public SearchEmployeeListPageElements() {
		PageFactory.initElements(driver, this);
	}
}
