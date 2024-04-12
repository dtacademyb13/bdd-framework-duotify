Feature: Data mapping scenarios


  @data_mapping
  Scenario: Verify data mapping of playlist creation
    Given the user is on the login page
    When the user enters valid username and password
    Then the user should be directed to the personal dashboard
    When the user creates a new playlist with a name "Chill Vibes"
    Then the data should be mapped correctly to the following columns in the "playlists" table 2:
      |  name          |
      |  owner         |


  Scenario: Verify data mapping of user registration process

    Given the user is on the login page
    And The user clicks on the sign up link
    When The user fills up the fields with valid info
    Then The user should be able to sign up successfully
    And the user should be created in the database
    Then the data should be mapped correctly to the following columns in the "users" table:
      | username   |
      | firstName |
      | lastName  |
      | email      |
      | password   |
