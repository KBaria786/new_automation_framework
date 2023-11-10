package com.wolters_kluwer.automation_framework.step_definitions;

import org.junit.Assert;

import com.wolters_kluwer.automation_framework.base.TestBase;
import com.wolters_kluwer.automation_framework.pages.EllipsisMenu;
import com.wolters_kluwer.automation_framework.pages.LoginPage;
import com.wolters_kluwer.automation_framework.pages.constants.Constants;
import com.wolters_kluwer.automation_framework.utility.driver.WebDriverController;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
	
	LoginPage loginPage;
	EllipsisMenu ellipsisMenu;
	WebDriverController webDriverController;
	
	@Before
	public void setUp() {
		webDriverController = TestBase.getWebDriverController();
		loginPage = new LoginPage(webDriverController);
		ellipsisMenu = new EllipsisMenu(webDriverController);
	}
	
	@Given("I am on the login page")
	public void userOnLoginPage() {
		Assert.assertTrue("Login page not visible", loginPage.isLoginPageVisible());
	}
	
	@When("I enter a {string} {string}")
	public void enterLoginField1(String validity, String fieldName) {
		if(validity.equals("valid")) {
			if(fieldName.equals("username")) {
				// Enter a valid username in the field
				loginPage.enterUsername("testAdminUser@wolterskluwer.com");
			}else {
				// Enter a valid password
				loginPage.enterPassword(Constants.internalUserPassword);
			}
		}else {
			if(fieldName.equals("username")) {
				// Enter an invalid username in the field
				loginPage.enterUsername("someUser@someDomain.com");
			}else {
				// Enter an invalid password
				loginPage.enterPassword("somePassword");
			}
		}
	}
	
	@And("I click the login button")
	public void clickLoginButton() {
		loginPage.clickLoginButton();
	}
	
	@Then("I should be logged into my account")
	public void isUserLoggedIn() {
		Assert.assertTrue("Invalid login", loginPage.isUserLoggedIn(Constants.internalUserUsername));
	}
	
	@Then("I should see an error message indicating invalid credentials")
	public void doesInvalidCredentialsMessageAppear() {
		Assert.assertTrue("Invalid credentials message not visible", loginPage.isInvalidCredentialsMessageVisible());
	}
	
	@Given("I am logged into my account")
	public void userIsLoggedIn() {
		loginPage.enterUsername(Constants.internalUserUsername);
		loginPage.enterPassword(Constants.internalUserPassword);
		loginPage.clickLoginButton();
		loginPage.isUserLoggedIn(Constants.internalUserUsername);
	}
	
	@When("I click the Logout button")
	public void logout() {
		loginPage.clickLogoutButtonFromMenu();
	}
	
	@Then("I should be logged out and redirected to the login page")
	public void isUserLoggedOut() {
		Assert.assertTrue("Login page not visible", loginPage.isLoginPageVisible());
	}
	
}