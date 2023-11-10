package com.wolters_kluwer.automation_framework.utility.driver;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wolters_kluwer.automation_framework.utility.PropertiesReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
* Class to obtain instance of web driver.
*/
public class WebDriverFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
	
	private WebDriverFactory() {}

	/**
	 * Method to obtain an instance of selenium web driver.
	 * @return Selenium web driver instance
	 */
	public static WebDriver getDriver() {
		WebDriver webDriver;
		
		Properties driverConfigProperties = PropertiesReader.getProperties(System.getProperty("user.dir") + "/src/main/resources/" + "driver-config.properties");
		String browser = driverConfigProperties.getProperty("browser");
		long implicitWaitDuration = Long.valueOf(driverConfigProperties.getProperty("implicitWaitDuration"));
		long pageLoadDuration = Long.valueOf(driverConfigProperties.getProperty("pageLoadDuration"));
		
		switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				webDriver = new ChromeDriver();
				logger.info("setting up chrome driver");
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				webDriver = new EdgeDriver();
				logger.info("setting up edge driver");
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				webDriver = new FirefoxDriver();
				logger.info("setting up fire fox driver");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value for browser name: " + browser);
		}
		
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitDuration));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadDuration));
		
		return webDriver;
	}
	
}
