package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;

public class LoginPageElements extends PageInitializer{
	
	
	@FindBy(xpath = "//div[@id='divUsername']/child::input")
	public WebElement userNametextBox;
	
	@FindBy(css = "input#txtPassword")
	public WebElement passwordTextBox;
	
	@FindBy(xpath = "//div[@id='divLoginButton']/child::input")
    public WebElement btnLogin;
	
	@FindBy(id = "divLogo")
	public WebElement syntaxLogo;
	
	@FindBy(id = "spanMessage")
	public WebElement spanMessage;
	
	@FindBy(id = "logInPanelHeading")
	public WebElement loginPanelHeading;
	/**
	 * method to log in
	 * @param username
	 * @param password
	 */
	public void loginToHrms(String username, String password) {
		login.userNametextBox.sendKeys(username);
		login.passwordTextBox.sendKeys(password);
		login.btnLogin.click();
	}
	
	
	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}
	
	
}


