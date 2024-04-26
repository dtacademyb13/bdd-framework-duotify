
@API
Feature: GET /users API endpoint features


  Scenario: Retrieve all users successfully

    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    When I send a "GET" request to the endpoint "/users"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the users amount should be 8190
    And the response should contain a list of all users with the following fields
      | id         |
      | username   |
      | firstName  |
      | lastName   |
      | email      |
      | password   |
      | signUpDate |
      | profilePic |