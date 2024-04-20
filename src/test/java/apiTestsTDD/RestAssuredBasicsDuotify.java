package apiTestsTDD;

import com.github.javafaker.Faker;
import io.cucumber.java.sl.In;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.openqa.selenium.json.Json;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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


    @Test
    public void testGET_USERS(){

        given().
                header("Accept", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                when().
                log().all().
                get("/users").
                then().
                log().all().
                statusCode(200).
                header("content-type"  ,"application/json").
                time(lessThan(2000L));

    }



    @Test
    public void testPOST_USER(){
        Faker faker = new Faker();

        String username = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String first = faker.name().firstName();
        String last = faker.name().lastName();



       String formattedBody =  String.format("""
                        {
                          "username": "%s",
                          "firstName": "%s",
                          "lastName": "%s",
                          "email": "%s",
                          "password": "%s"
                        }
                        """, username+UUID.randomUUID(), first, last, email,password);

        System.out.println(formattedBody);

        given().
                body(formattedBody).
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
        when().
                log().all().
                post("/user").
        then().
                log().all().
                statusCode(201);

    }


    @Test
    public void testPUT_USER(){
        Faker faker = new Faker();

        String username = faker.name().username();




        String formattedBody =  String.format("""
                        {
                          "username": "%s",
                          "firstName": "Bill",
                          "lastName": "Abernathy",
                          "email": "susy.rath@gmail.com"
                        }
                        """, username+UUID.randomUUID());

        System.out.println(formattedBody);

        given().
                body(formattedBody).
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "1709883857").
                when().
                log().all().
                put("/user").
                then().
                log().all().
                statusCode(200);

    }


    @Test
    public void testPATCH_USER(){
        Faker faker = new Faker();

        String username = faker.name().username();




        String formattedBody =  String.format("""
                        {
                          "username": "%s"
                        }
                        """, username+UUID.randomUUID());

        System.out.println(formattedBody);

        given().
                body(formattedBody).
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "1709883857").
                when().
                log().all().
                patch("/user").
                then().
                log().all().
                statusCode(200);

    }


    @Test
    public void testDELETE_USER(){


        given().

                header("Accept", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "1709883855").
                when().
                log().all().
                delete("/user").
                then().
                log().all().
                statusCode(200);

    }



    @Test
    public void gPathDemo(){

        Map<String, String > expectedPayload =
                Map.of( "id" ,"1709870426",
                        "username", "duotech2023",
                        "firstName", "Duotech",
                        "lastName", "Academy",
                        "email", "deja.toy@hotmail.com",
                        "createdAt", "2023-03-24 00:00:00");



        given().
                header("Accept", "application/json").
                queryParam("id", expectedPayload.get("id")).
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                when().
                log().all(). // log the request details
                get("/user").
                then().
                log().all().
                statusCode(200).
                body("id", equalTo(expectedPayload.get("id")) ).
                body("username", equalTo(expectedPayload.get("username")) ).
                body("lastName", equalTo(expectedPayload.get("lastName")) ).
                body("firstName", equalTo(expectedPayload.get("firstName")) ).
                body("email", equalTo(expectedPayload.get("email")) ).
                body("createdAt", equalTo(expectedPayload.get("createdAt")) );

    }

    @Test
    public void jsonPath2(){
        Faker faker = new Faker();

        String username = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String first = faker.name().firstName();
        String last = faker.name().lastName();



        String formattedBody =  String.format("""
                        {
                          "username": "%s",
                          "firstName": "%s",
                          "lastName": "%s",
                          "email": "%s",
                         
                        }
                        """, username+UUID.randomUUID(), first, last, email);

        System.out.println(formattedBody);

       List<String> extractedList =  given().
                body(formattedBody).
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                when().
                log().all().
                post("/user").
                then().
                log().all().
                statusCode(422).
                body("status", equalTo(422)).
                body("message", equalTo("Missing or Invalid Required Fields!")).
                body("fields", equalTo(List.of("username","firstName", "lastName", "email", "password"))).
                body("fields[2]", equalTo("lastName")).extract().jsonPath().getList("fields");


        System.out.println(extractedList);

    }


    @Test
    public void multiStepWorkflowPOSTandGET(){

        // Create a user with the POST
        Faker faker = new Faker();
        String username = faker.name().username()+UUID.randomUUID();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String first = faker.name().firstName();
        String last = faker.name().lastName();

        String formattedBody =  String.format("""
                        {
                          "username": "%s",
                          "firstName": "%s",
                          "lastName": "%s",
                          "email": "%s",
                          "password": "%s"
                        }
                        """, username, first, last, email,password);

        System.out.println(formattedBody);

        JsonPath jsonPath = given().
                body(formattedBody).
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                when().
                log().all().
                post("/user").
                then().
                log().all().
//                statusCode(201).extract().path("user_id"); // you can extract body values with path(jsonPath expression)
                statusCode(201).extract().jsonPath(); // you can extract body values with jsonPath()

        String userId = jsonPath.getString("user_id");
        Integer code = jsonPath.getInt("http_code");

        System.out.println("Returned value: " + userId);

        // Verify the user creation through GET endpoint by using the user id returned by POST endpoint

        given().
                header("Accept", "application/json").
                queryParam("id", userId).
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                when().
                log().all(). // log the request details
                get("/user").
                then().
                log().all().
                statusCode(200).
                body("id", is(userId)).
//                body("username", is(username)).
                body("firstName", is(first)).
                body("lastName", is(last)).
                body("email", is(email));
//                body("createdAt", is(LocalDateTime.now()));


    }

















}
