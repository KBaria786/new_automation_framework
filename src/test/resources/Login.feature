Feature: Login Page
  As a user, I want to be able to log in to my account.
  
  Scenario: Successful login
    Given I am on the login page
    When I enter a "valid" "username"
    And I enter a "valid" "password"
    And I click the login button
    Then I should be logged into my account
 
  Scenario: Login with invalid username
    Given I am on the login page
    When I enter a "invalid" "username"
    And I enter a "valid" "password"
    And I click the login button
    Then I should see an error message indicating invalid credentials
 
  Scenario: Login with invalid password
    Given I am on the login page
    When I enter a "valid" "username"
    And I enter a "invalid" "password"
    And I click the login button
    Then I should see an error message indicating invalid credentials
 
  #Scenario: Login with empty fields
    #Given I am on the login page
    #When I leave the username and password fields empty
    #And I click the login button
    #Then I should see an error message indicating required fields

  Scenario: Logout
    Given I am logged into my account
    When I click the Logout button
    Then I should be logged out and redirected to the login page

  #Scenario: Login with case-insensitive username
    #Given I am on the login page
    #When I enter my username with a different case
    #And I enter my valid password
    #And I click the login button
    #Then I should be logged into my account
