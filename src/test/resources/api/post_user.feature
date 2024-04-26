@API


Feature: POST /user API endpoint features


  Scenario: Create a new user using String as payload

    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the request body is set to the following payload
      """
      {
        "username": "%s",
        "firstName": "%s",
        "lastName": "%s",
        "email": "%s",
        "password": "%s"
      }
      """

    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 201
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 2000 ms