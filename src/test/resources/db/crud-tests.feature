Feature:  CRUD Tests


# UI to DB
  Scenario: User Creation CRUD test - Create
#    UI creation
    Given the user is on the login page
    And The user clicks on the sign up link
    When The user fills up the fields with valid info
    Then The user should be able to sign up successfully
#    Verify the created user on the DB layer
    And the user should be created in the database


  Scenario: User Info Retrieval CRUD test - Read
#    Create a new user
    Given the user is on the login page
    And The user clicks on the sign up link
    When The user fills up the fields with valid info
    Then The user should be able to sign up successfully
#    Verify the user's info on the DB layer
    And the user's info should be correct


  Scenario: User Email Update CRUD test - UPDATE
#    Update the user email
    Given the user is on the login page
    When the user enters valid username and password
    Then the user should be directed to the personal dashboard
    When the user updates the email
    Then the success message should be displayed
#    Verify the updated email via DB layer
    And the user's email should be correctly updated in the database

  @ui_to_db_crud
  Scenario: User Playlist Deletion CRUD test - Delete
#    Create a new playlist
    Given the user is on the login page
    When the user enters valid username and password
    Then the user should be directed to the personal dashboard
    When the user creates a new playlist with a name "Relaxed Music"
    Then the playlist should be created in the db
#    Delete the playlist on the ui and verify thru db
    When the user deletes the playlist with a name "Relaxed Music"
    Then the playlist should be deleted in the db


#    DB to UI

  Scenario: User Creation CRUD test - Create - DB to UI
#    Create a user on the DB
    Given the user with random credentials is created in the db
    When the user is on the login page
    And the user enters the same credentials
    Then the user should be directed to the personal dashboard


  @db_to_ui_crud
  Scenario: User Email update CRUD test - Update - DB to UI
#    Update the email for the test user to a specific email
    Given the user email is updated in the db
#    Verify the email update on the ui
    When the user is on the login page
    And the user enters valid username and password
    Then the user should be directed to the personal dashboard
    Then the updated user email should be correct

