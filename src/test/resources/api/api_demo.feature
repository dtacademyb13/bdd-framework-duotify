Feature: Demo

  @API
  Scenario: Test Api endpoint

    Given The base uri is set
    And "Accept" header is set to "application/vnd.github+json"
    And "username" path Parameter is set to "dtacademyb13"
    And "pages" query Parameter is set to "2"
    When I send a "GET" request to endpoint "/users/{username}"
    Then the status code should be 200
    And response time should be less than 2000 ms
