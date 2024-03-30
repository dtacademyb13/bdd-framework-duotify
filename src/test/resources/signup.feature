Feature: User sign up

  Background: Common steps for all scenarios
    Given the user is on the login page
    And The user clicks on the sign up link


  Scenario: Sign up with valid information
    When The user fills up the fields with valid info
    Then The user should be able to sign up successfully


  Scenario: Sign up with valid information parametrized
    When The user fills up the fields with valid info such as "duotech9999" "Duotech" "Academy" "duotech2029@gmail.com" "duotech2024"
    Then The user should be able to sign up successfully

  @signup
  Scenario: Sign up with valid information with datatable
    When The user fills up the fields with the following info
      | duotech9998           |
      | Duotech               |
      | Academy               |
      | duotech2028@gmail.com |
      | duotech2024           |
    Then The user should be able to sign up successfully


  Scenario: User enters invalid email address
    When the user enters an invalid email address
    Then the user should see an error message for email


  Scenario: User enters a weak password

    When the user enters a weak password
    And clicks on the sign-up button
    Then the user should see an error message for password
    And the sign-up process should not proceed


  Scenario: User password and confirm password do not match

    When the user enters a password and enters a different password in the confirm password field
    And clicks on the sign-up button
    Then the user should see an error message for confirm password
    And the sign-up process should not proceed

  Scenario: User already has an account

    When the user enters an email address that is already associated with an account
    And clicks on the sign-up button
    Then the user should see an error message for an already used email
    And the sign-up process should not proceed