Feature: GET User Endpoint Features



  Scenario: Get User


#     given().
#           header("Accept", "application/json").
#           queryParam("id", "1709870426").
#           queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
#        when().
#                log().all(). // log the request details
#               get("/user").
#        then().
#             log().all().
#              statusCode(200).
#              header("cache-control" ,"no-store, no-cache, must-revalidate").
#              header("content-type"  ,"application/json").
#              time(lessThan(2000L));
    Given 'Accept' header is set to  'application/json'
    And  "id" query parameter is set to "1709870426"
    And  "api_key" query parameter is set to "1709870426"
    When "GET" request is sent to '/user' endpoint
    Then status code should be 200

