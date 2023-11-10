package com.wolters_kluwer.automation_framework.pages;

import java.time.Duration;

import com.wolters_kluwer.automation_framework.pages.object_repository.CommonOperationsOR;
import com.wolters_kluwer.automation_framework.utility.driver.WebDriverController;

public class CommonOperations {

	protected WebDriverController webDriverController;

	public CommonOperations(WebDriverController webDriverController) {
		this.webDriverController = webDriverController;
	}

	public WebDriverController getWebDriverController() {
		return webDriverController;
	}

	public void setWebDriverController(WebDriverController webDriverController) {
		this.webDriverController = webDriverController;
	}

	public boolean waitForLoadingOverlayToDisappear() {
		webDriverController.reporting().enableReporting(false);
		boolean operationFlag = webDriverController.waitForInvisibilityOfElement(
				"Wait for loading overlay to disappear", CommonOperationsOR.loadingOverlay, Duration.ofSeconds(10));
		webDriverController.reporting().enableReporting(true);
		return operationFlag;
	}

}
