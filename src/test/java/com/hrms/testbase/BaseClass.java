package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected static WebDriver driver; //or public

	/*
	 * @method = to open the browser and to wait for it to be loaded and refresh it
	 * it uses the method readProperties(); from the ConfigsReader class; and reads CONFIGURATION_FILEPATH file from Constants class
	 * By calling method getPropValue(key); from the ConfigsReader class; we are getting the value of the key from configuration.properties file in the folder configs
	 * by passing the CONFIGURATION_FILEPATH from Constants class(utils)
	 */
	  
	

	public static void setUp() {

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		//Look at this line
		String headless = ConfigsReader.getPropValue("headless");
		

		switch (ConfigsReader.getPropValue("browser").toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			if(headless.equalsIgnoreCase("true")) {
				chromeOptions.setHeadless(true);
				driver = new ChromeDriver(chromeOptions);
			}else {
				driver = new ChromeDriver();
			}
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getPropValue("applicationUrl"));
		PageInitializer.initializePageObjects();
	}

	
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}
