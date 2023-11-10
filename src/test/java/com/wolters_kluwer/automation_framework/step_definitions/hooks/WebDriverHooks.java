package com.wolters_kluwer.automation_framework.step_definitions.hooks;

import com.wolters_kluwer.automation_framework.base.TestBase;
import com.wolters_kluwer.automation_framework.utility.reporting.ReportingUtility;
import com.wolters_kluwer.automation_framework.utility.reporting.provider.AllureReportingProvider;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebDriverHooks {

	@Before
	public void setUp() {
		TestBase.setUp();
		ReportingUtility.setReportingProvider(new AllureReportingProvider());
		TestBase.getWebDriverController().get("Launch Proviso", "https://qa-proviso.wolterskluwer.com/");
	}
	
	@After
	public void tearDown() {
		TestBase.tearDown();
	}
	
}
