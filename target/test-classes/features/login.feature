Feature: User Login
  As a user, I want to log in to the application so that I can access my account.

  Scenario: Successful login with valid username credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And the user clicks the login button
    Then the user should be redirected to the dashboard
    And the user should see a welcome message with their username

  Scenario: Successful login with valid phone number credentials
    Given the user is on the login page
    When the user enters a valid phone number
    And the user clicks the login button
    Then the user should be redirected to the dashboard
    And the user should see a welcome message with their username

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username or password
    And the user clicks the login button
    Then the user should see an error message "Invalid username or password"
    And the user should remain on the login page

  Scenario: Unsuccessful login with empty credentials
    Given the user is on the login page
    When the user clicks the login button without entering credentials
    Then the user should see an error message "Username and password are required"
    And the user should remain on the login page