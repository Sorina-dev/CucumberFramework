package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class DashboardPageElements extends BaseClass {


	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement pimLinkBtn;
	
	@FindBy(linkText="Add Employee")
	public WebElement addEmployeeBtn;
	
	@FindBy(css = "a#menu_pim_viewEmployeeList")
	public WebElement empListBtn;

	@FindBy(id = "menu_admin_viewAdminModule")
	public WebElement adminLinkBtn;
	
	@FindBy(id = "menu_leave_viewLeaveModule")
	public WebElement leaveLinkBtn;

	@FindBy(id = "menu_time_viewTimeModule")
	public WebElement timeLinkBtn;
	
	@FindBy(id = "menu_time_viewJobTitleModule")
	public WebElement jonTitlesLinkBtn;

	@FindBy(id = "menu_recruitment_viewRecruitmentModule")
	public WebElement recruitmentLinkBtn;

	@FindBy(id = "menu_dashboard_index")
	public WebElement dashboardLinkBtn;

	@FindBy(id = "menu_directory_viewDirectory")
	public WebElement directoryLinkBtn;
	
	@FindBy(css = "a#welcome")
	public WebElement welcome;
	
	@FindBy(xpath = "//div[@class = 'menu']/ul/li")
	public List<WebElement> dashTabs;

	@FindBy(xpath = "//a[text() = 'Add Employee']")
	public WebElement addEmpBtn;

	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}
}
