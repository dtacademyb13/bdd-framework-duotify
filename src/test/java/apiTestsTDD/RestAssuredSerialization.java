package apiTestsTDD;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pojo.User;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredSerialization {


    @Test
    public void serializeAsString(){

        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
        given().
                body("{ \"signUpDate\": \"2022-09-27 00:00:00\", \"profilePic\": \"assets/images/profile-pics/head_\"}").
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "88").
                when().
                log().all().
                patch("/user").
                then().
                log().all().
                statusCode(200);
    }

    @Test
    public void serializeAsMap(){
    // Add jackson dependency  for any java object serialization
       Faker faker = new Faker();

        Map<String, String> map = Map.of("firstName", faker.name().firstName(),
                "lastName", faker.name().lastName(),
                "password", faker.internet().password(),
                "signUpDate", "2022-09-27 00:00:00",
                "profilePic", "assets/images/profile-pics/head_");


        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
        given().
                body(map).
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "88").
                when().
                log().all().
                patch("/user").
                then().
                log().all().
                statusCode(200);
    }


    @Test
    public void serializeAsFile(){


        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
        given().
                body(new File("src/test/java/apiTestsTDD/payload.json")).
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "88").
                when().
                log().all().
                patch("/user").
                then().
                log().all().
                statusCode(200);
    }


    @Test
    public void serializeAsList(){


        List<String> list = List.of("email1@gmail.com", "email2@gmail.com", "email2@gmail.com");

        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
        given().
                body(list).
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "88").
                when().
                log().all().
                patch("/user").
                then().
                log().all().
                statusCode(200);
    }



    @Test
    public void serializeAsJavaObjectPOJO(){

        User user = new User(
                "9",
                "Mr Jekyll",
                "Jekyll",
                "Hyde",
                "hyde@gmail.com",
                "cddcscdds",
                "2022-09-27 00:00:00",
                "assets/images/profile-pics/head_",
                "2022-09-27 00:00:00"
        );


        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
        given().
                body(user).
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "88").
                when().
                log().all().
                patch("/user").
                then().
                log().all().
                statusCode(200);
    }

    @Test
    public void serializeAsPOJOPartial(){

        User user = new User();
        user.setFirstName("Mr Jekyll");
        user.setLastName("Dr Hyde");

        User user2 =
                User.builder()
                .firstName("Sherlock")
                .lastName("Holmes")
                .build();



        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
        given().
                body(user2).
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "88").
                when().
                log().all().
                patch("/user").
                then().
                log().all().
                statusCode(200);
    }
}
