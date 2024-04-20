package apiTestsTDD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAssuredBasicsDuotify {



    @BeforeClass
    public void setupClass(){
        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
    }



    @Test
    public void testGETUSER(){


        given().
           header("Accept", "application/json").
           queryParam("id", "1709870426").
           queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
        when().
                log().all(). // log the request details
               get("/user").
        then().
             log().all().
              statusCode(200).
              header("cache-control" ,"no-store, no-cache, must-revalidate").
              header("content-type"  ,"application/json").
              time(lessThan(2000L));






    }



}
