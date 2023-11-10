package com.wolters_kluwer.automation_framework.pages;

import com.wolters_kluwer.automation_framework.pages.object_repository.EllipsisMenuOR;
import com.wolters_kluwer.automation_framework.utility.driver.WebDriverController;

public class EllipsisMenu extends CommonOperations {

	public EllipsisMenu(WebDriverController webDriverController) {
		super(webDriverController);
	}

	public boolean clickEllipsisMenu() {
		super.waitForLoadingOverlayToDisappear();
		return webDriverController.click("Click ellipsis menu icon", EllipsisMenuOR.ellipsisMenu);
	}

	public boolean clickChangePasswordButton() {
		return webDriverController.click("Click change password button", EllipsisMenuOR.changePasswordButton);
	}

	public boolean clickReportButton() {
		return webDriverController.click("Click report button", EllipsisMenuOR.reportButton);
	}

	public boolean clickBulkActionButton() {
		return webDriverController.click("Click bulk actions button", EllipsisMenuOR.bulkActionButton);
	}

	public boolean clickTaxonomyUtilityButton() {
		return webDriverController.click("Click taxonomy utility button", EllipsisMenuOR.taxonomyUtilityButton);
	}

	public boolean clickTaggingUtilityButton() {
		return webDriverController.click("Click tagging utility button", EllipsisMenuOR.taggingUtilityButton);
	}

	public boolean clickCodifyUtilityButton() {
		return webDriverController.click("Click codify utility button", EllipsisMenuOR.codifyUtilityButton);
	}

	public boolean clickUploadClusterButton() {
		return webDriverController.click("Click upload cluster button", EllipsisMenuOR.uploadClusterButton);
	}

	public boolean clickRegulatoryChangeRecordsButton() {
		return webDriverController.click("Click regulatory change records button",
				EllipsisMenuOR.regulatoryChangeRecordsButton);
	}

	public boolean clickMaterialitySettingsButton() {
		return webDriverController.click("Click materiality settings button", EllipsisMenuOR.materialitySettingsButton);
	}

	public boolean clickLogoutButton() {
		return webDriverController.click("Click logout button", EllipsisMenuOR.logoutButton);
	}

}