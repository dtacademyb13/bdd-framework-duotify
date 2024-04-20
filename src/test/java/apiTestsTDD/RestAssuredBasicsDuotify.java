package apiTestsTDD;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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











}
