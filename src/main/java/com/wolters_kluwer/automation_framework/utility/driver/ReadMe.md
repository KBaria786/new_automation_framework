# Driver

Package containing a class to create and a Selenium Web Driver instance and a class to perform selenium operations.

### WebDriverFactory
Class to create Selenium Web Driver instances. A properties file named **driver-config.properties** file is present under the **src/main/resources** in order to fetch **browser**, **implicit wait duration** & **page load duration** values.
```
browser:chrome
pageLoadDuration:10
implicitWaitDuration:10
```

### WebDriverController
Class that contains various to perform Selenium operations, these methods contain logging and reporting. A **ReportingProvider** implementation must be provided to the **ReportingUtility** class using in order for reporting to work.

## Usage

```java
import com.wk.automation_framework.utility.driver.WebDriverFactory;
import com.wk.automation_framework.utility.reporting.ReportingUtility;
import com.wk.automation_framework.utility.reporting.provider.CustomReportingProviderImpl;
import com.wk.automation_framework.utility.driver.WebDriverController;

// create web driver instance
WebDriver webDriver = WebDriverFactory.getDriver();

// set reporting provider instance for ReportingUtility class
ReportingUtility.setReportingProvider(new CustomReportingProviderImpl());

// create WebDriverController instance
WebDriverController webDriverController = new WebDriverController(webDriver);

// perform selenium operations
WebElement username = webDriverController.findElement(By.id("username"));
webDriverController.clearAndSendKeys("Enter username", username, "some username");
webDriverController.clearAndSendKeys("Enter password", By.xpath("password"), "some password");
webDriverController.click("Click login button", "xpath~//button[@name='loginButton']");

// enable / disable reporting and screenshots
webDriverController.reporting.enableSuccessScreenshots(true);
webDriverController.reporting.enableFailureScreenshots(false);
webDriverController.reporting.enableReporting(false);
```