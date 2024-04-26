@API
Feature: Delete /USER endpoint features

  @api_demo
  Scenario: Delete an existing user


#    Create a user to be deleted

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

#  Store the created user's id so that it can be used with the delete request
    And the response body "id" value is stored

##    Delete the user

##   Reset the request specification for this request
    And the request specification is reset

    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the request "id" query parameter is set to the stored value
    When I send a "DELETE" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 2000 ms
    And the response body should have "message" field with value "User deleted successfully"
