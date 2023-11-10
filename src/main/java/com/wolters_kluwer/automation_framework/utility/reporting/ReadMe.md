# Reporting
Package containing classes that can be used to manage reporting & reporting test case steps.

### ReportingProvider
An interface containing method signatures for reporting purposes. The implementation of these methods is used inside ReportingUtility class.

### ReportingUtility
Class that needs an implementation of the ReportingProvider interface. the methods of this implementation are called statically. Example. 
```java
import com.wk.automation_framework.utility.reporting.ReportingUtility;
import com.wk.automation_framework.utility.reporting.provider.CustomReportingProviderImpl;

// set reporting provider
ReportingUtility.setReportingProvider(new CustomReportingProviderImpl());

// report steps
ReportingUtility.reportStepSuccess("Click on edit button", "Successfully clicked web element");
ReportingUtility.reportStepFailure("Click save button", "Exception occured while clicking web element", exception);
```