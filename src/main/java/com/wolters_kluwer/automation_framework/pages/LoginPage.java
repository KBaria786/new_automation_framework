package com.wolters_kluwer.automation_framework.pages;

import java.time.Duration;

import com.wolters_kluwer.automation_framework.pages.object_repository.LoginPageOR;
import com.wolters_kluwer.automation_framework.utility.driver.WebDriverController;

public class LoginPage extends CommonOperations {
	
	private EllipsisMenu ellipsisMenu;
	
	private Duration defaultWaitDuration = Duration.ofSeconds(10);
	
	public LoginPage(WebDriverController webDriverController) {
		super(webDriverController);
		ellipsisMenu = new EllipsisMenu(webDriverController);
	}
	
	// login
	
	public boolean isLoginPageVisible() {
		return webDriverController.waitForVisibilityOfElement("Is login page visible", LoginPageOR.usernameInput, defaultWaitDuration) != null;
	}
	
	public boolean enterUsername(String username) {
		return webDriverController.clearAndSendKeys("Enter username", LoginPageOR.usernameInput, username);
	}
	
	public boolean enterPassword(String password) {
		return webDriverController.clearAndSendKeys("Enter password", LoginPageOR.passwordInput, password);
	}
	
	public boolean clickLoginButton() {
		return webDriverController.click("Click login button", LoginPageOR.loginButton);
	}
	
	public boolean isInvalidCredentialsMessageVisible() {
		return webDriverController.waitForVisibilityOfElement("Check visibility of invalid credentials message", LoginPageOR.invalidCredentialsMessage, Duration.ofSeconds(10)) != null;
	}
	
	public boolean isUserLoggedIn(String username) {
		waitForLoadingOverlayToDisappear();
		String loggedInUsername = webDriverController.findElement(LoginPageOR.currentLoggedInUserInfo).getText();
		return username.equalsIgnoreCase(loggedInUsername);
	}
	
	// logout
	
	public boolean clickLogoutButtonFromMenu() {
		ellipsisMenu.clickEllipsisMenu();
		return ellipsisMenu.clickLogoutButton();
	}
	
	// change password
	
	private ChangePassword changePassword = new ChangePassword();
	
	public ChangePassword changePassword() {
		return this.changePassword;
	}
	
	public class ChangePassword {
		
		private ChangePassword() {}
		
		public boolean getChangePasswordPage() {
			ellipsisMenu.clickEllipsisMenu();
			return ellipsisMenu.clickChangePasswordButton();
		}
		
		public boolean enterCurrentPassword(String currentPassword) {
			return webDriverController.clearAndSendKeys("Enter current password", LoginPageOR.ChangePassword.currentPasswordInput, currentPassword);
		}
		
		public boolean enterNewPassword(String newPassword) {
			return webDriverController.clearAndSendKeys("Enter new password", LoginPageOR.ChangePassword.newPasswordInput, newPassword);
		}
		
		public boolean enterConfirmPassword(String confirmPassword) {
			return webDriverController.clearAndSendKeys("Enter confirm password", LoginPageOR.ChangePassword.confirmPasswordInput, confirmPassword);
		}
		
		public boolean clickBackButton() {
			return webDriverController.click("Click back button", LoginPageOR.ChangePassword.backButton);
		}
		
		public boolean clickChangePasswordButton() {
			return webDriverController.click("Click change password button", LoginPageOR.ChangePassword.changePasswordButton);
		}
		
	}
	
}