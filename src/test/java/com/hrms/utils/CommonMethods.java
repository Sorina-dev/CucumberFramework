package com.hrms.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {
	/**
	 * Method that sends text to any given element
	 * 
	 * @param element
	 * @param text
	 */
	
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Method that sends text to any given element and need to press Enter Key
	 * 
	 * @param element
	 * @param text
	 * @param Enter
	 */
	public static void sendTextEnter(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
	}

	/**
	 * Method return Object of JavaScript Executor type
	 * 
	 * @return js object
	 */
	public static JavascriptExecutor getJSExecutor() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	/**
	 * Method performs click using JavaScript executor
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSExecutor().executeScript("arguments[0].click();", element);
	}

	/**
	 * Methods scrolls up using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0, -" + pixel + ")");
	}

	/**
	 * Methods scrolls down using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * Method create the WebDriverWait object
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
	}

	/**
	 * method to wait until is element visible
	 * 
	 * @param element
	 */
	public static void waitForVisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * method to wait until is List of elements is visible
	 * 
	 * @param element
	 */
	public static void waitForVisibilityofList(List<WebElement> list) {
		getWaitObject().until(ExpectedConditions.visibilityOfAllElements(list));
	}

	/**
	 * method to wait until is element clickable
	 * 
	 * @param element
	 */

	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * method to click on the element when is clickable
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	/**
	 * method to switch to simple alert and accept it
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert is present");
		}
	}

	/**
	 * method to switch to confirm alert and dismiss it
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert is present");
		}
	}

	/**
	 * method to switch to alert and get and return the alert text
	 * 
	 * @return
	 */
	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert is present");
		}
		return alertText;
	}

	/**
	 * method to switch to frame by string
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to switch to frame by web element
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement iframe) {
		try {
			driver.switchTo().frame(iframe);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to switch to frame by index
	 * 
	 * @param index
	 */

	public static void switchToFrame(int frameIndex) {
		try {
			driver.switchTo().frame(frameIndex);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * takes screenshots and giving the time stamp
	 * 
	 * @param fileName
	 */
	public static void takeScreenshotFile(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try { // below method
			FileUtils.copyFile(src, new File(Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that will take a screenshot and store with name in specified location
	 * with .png extension
	 * 
	 * @param fileName
	 */
	public static byte[] takeScreenshot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);

		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bytes;

	}

	/**
	 * this returns number of milliseconds since January 1, 1970/ we don't need it
	 */
	public void getTimeStamp1() {
		Date date = new Date();
		date.getTime();
	}

	/**
	 * This method will generate timeStamp
	 * 
	 * @return
	 */
	public static String getTimeStamp() {// had to add it to CommonMethods class takeScreenshot() above method^
		// class
		Date date = new Date();
		// class extends DateFormat //years-month-day- hours -min - sec
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");// we changed ":" into "_" cuz it doesn't
																			// support
		// method that returns String date
		return sdf.format(date);
	}

	/**
	 * this method will click on checkbob or radio button by the given list web
	 * elements and value
	 * 
	 * @param radioOrCheckBoxes
	 * @param value
	 */
	public void clickRadioOrCheckBox(List<WebElement> radioOrCheckBoxes, String value) {
		String actualValue;
		for (WebElement radioOrCheckbox : radioOrCheckBoxes) {
			actualValue = radioOrCheckbox.getAttribute("value").trim();
			if (radioOrCheckbox.isEnabled() && actualValue.equals(value)) {
				jsClick(radioOrCheckbox);
				break;
			}
		}
	}

	/**
	 * method to select an option from dropdown by given webelement and visible text
	 * value
	 * 
	 * @param dd
	 * @param visibleTextOrValue
	 */
	public static void selectDDValue(WebElement dd, String visibleTextOrValue) {
		try {
			Select select = new Select(dd);
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) {
				if (option.getText().equals(visibleTextOrValue)) {
					select.selectByVisibleText(visibleTextOrValue);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to select an option from dropdown by given webelement and index
	 * 
	 * @param dd
	 * @param index
	 */
	public static void selectDDValue(WebElement dd, int index) {
		try {
			Select select = new Select(dd);
			List<WebElement> options = select.getOptions();

			int size = options.size();
			if (size > index) {
				select.selectByIndex(index);
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method will switch to child window
	 */
	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		
	}
	
	/**
	 * this method reads the jsonFile and convert it into a String 
	 */
	static String jsonFile;
	public static String readJson(String fileName) {
		try {
			jsonFile = new String(Files.readAllBytes(Paths.get(fileName)));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return jsonFile;
	}
	
}
