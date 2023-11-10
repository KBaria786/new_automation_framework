package com.wolters_kluwer.automation_framework.pages.object_repository;

public class LoginPageOR {

	public static final String usernameInput = "xpath~//input[@name='username']";
	public static final String passwordInput = "xpath~//input[@name='password']";

	public static final String loginButton = "xpath~//button[normalize-space()='Login']";

	public static final String invalidCredentialsMessage = "xpath~//p[text()='Username or password is invalid']";

	public static final String currentLoggedInUserInfo = "xpath~//i[contains(@class, 'icon-user-icon')]//parent::div";

	// change password
	public static class ChangePassword {
		public static final String currentPasswordInput = "xpath~//input[@name='Password']";
		public static final String newPasswordInput = "xpath~//input[@name='newPassword']";
		public static final String confirmPasswordInput = "xpath~//input[@name='confirmPassword']";

		public static final String backButton = "xpath~//button[text()='Back']";
		public static final String changePasswordButton = "xpath~//button[text()='Change Password']";
	}

}
