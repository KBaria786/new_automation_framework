package com.wolters_kluwer.automation_framework.base;

import org.openqa.selenium.WebDriver;

import com.wolters_kluwer.automation_framework.utility.driver.WebDriverController;
import com.wolters_kluwer.automation_framework.utility.driver.WebDriverFactory;

public class TestBase {
	
	private static TestBase testBaseSingletonInstance;
	
	private static WebDriver webDriver;
	private static WebDriverController webDriverController;
	
	public static WebDriverController getWebDriverController() {
		return webDriverController;
	}
	
	private TestBase() {
		webDriver = WebDriverFactory.getDriver();
		webDriver.manage().window().maximize();
		webDriverController = new WebDriverController(webDriver);
	}
	
	public static void setUp() {
		if(testBaseSingletonInstance == null) {
			testBaseSingletonInstance = new TestBase();
		}
	}
	
	public static void tearDown() {
		if(webDriver != null) {
			webDriver.quit();
		}
		testBaseSingletonInstance = null;
	}
	
}
