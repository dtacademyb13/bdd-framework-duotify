Feature: User login for Music Streaming App
  As a user, I want to be able to login to my account
  so that I can access the feature of the application

  Scenario: Successful login wih a valid username and password

    Given the user is on the homepage
    When the user enters valid username and password
    Then the user should be directed to the personal dashboard


  Scenario: Unsuccessful login wih a invalid username and password

    Given the user is on the homepage
    When the user enters invalid username and password
    Then the user should not be directed to the personal dashboard





