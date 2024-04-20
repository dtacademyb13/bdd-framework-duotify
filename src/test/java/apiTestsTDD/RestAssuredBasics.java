package apiTestsTDD;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class RestAssuredBasics {


    static {
        RestAssured.baseURI = "https://api.github.com";
    }



    @Test
    public void demo(){



        given(). // request specifications
           header("Accept", "application/vnd.github+json").
           pathParam("username", "dtacademyb13").
//           queryParam().
//            body().

        when().   //request type
                log().all(). // log the request details
               get("/users/{username}").
        then(). //assertion
             log().all(). //log the response details
            statusCode(200);




    }

    @Test
    public void demo2(){



        given(). // request specifications

                header("Accept", "application/vnd.github+json").
                queryParam("per_page", "10").
                queryParam("since", "5").
//            body().

        when().   //request type
                log().all(). // log the request details
                get("/users").
        then(). //assertion
                log().all(). //log the response details
                statusCode(200);







    }


    @Test
    public void restAssuredCode(){


       //Given ->  RequestSpecification
 RequestSpecification requestSpecification = given().

                header("Accept", "application/vnd.github+json").
                queryParam("per_page", "10").
                queryParam("since", "5");


 // When -> Response
        Response response = requestSpecification.when().
                log().all().
                get("/users");

// Then -> ValidatableResponse
        response.then().
                log().all().
                statusCode(200);







    }








}
