package apiTestsTDD;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import pojo.PlaylistsResponse;
import pojo.User;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestAssuredDeserialization {


//    {
//        "id": "89",
//            "username": "louise.king",
//            "firstName": "Malcolm",
//            "lastName": "Beahan",
//            "email": "Lucius.schimmel@yahoo.com",
//            "createdAt": "2022-09-29 00:00:00"
//    }

    @Test
    public void deserializeAsString() {

        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
        String responsePayload = given().
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "89").
                when().
                log().all().
                get("/user").
                then().
                log().all().
//                statusCode(200).extract().asString();
        statusCode(200).extract().asPrettyString();

        System.out.println(responsePayload);
    }


    @Test
    public void deserializeAsMap() {

        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
//        Map map = given().
        Map<String, Object> map = given().
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "89").
                when().
                log().all().
                get("/user").
                then().
                log().all().
//                statusCode(200).extract().asString();
        statusCode(200)
//                .extract().as(Map.class); //deserialize as raw map
//                .extract().as(new TypeRef<Map<String, Object>>() {});//deserialize as specific type of Map
                .extract().as(new TypeRef<>() {
                });//deserialize as specific type of Map

        System.out.println(map);
    }

    @Test
    public void deserializeAsListOfMaps() {

        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
        List<Map<String, String>> usersList = given().
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").

                when().
                log().all().
                get("/users").
                then().
                log().all().
                statusCode(200)
//
//                .extract().as(List.class);//deserialize as raw list
                .extract().as(new TypeRef<>() {
                });//deserialize as specific type of Map

        System.out.println(usersList);

        for (Map<String, String> user : usersList) {
            System.out.println(user);
        }
    }


    @Test
    public void deserializeAsPOJO() {

        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";


        User responseBodyAsUserPOJO = given().
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", "89").
                when().
                log().all().
                get("/user").
                then().
                log().all().
                statusCode(200)
//
                .extract().as(User.class);//deserialize as a User POJO

        System.out.println(responseBodyAsUserPOJO);

        System.out.println(responseBodyAsUserPOJO.getEmail());
    }


    @Test
    public void deserializeAsListOfPOJO() {

        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
        List<User> users =
                given().
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").

                when().
                log().all().
                get("/users").
                then().
                log().all().
                statusCode(200)

                .extract().as(new TypeRef<List<User>>() {
                });//deserialize as specific type of List


          users.forEach(System.out::println);


    }


    @Test
    public void deserializeComplexJsonAsPOJO() {

        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";

        String jwtToken  = given().
                header("Accept", "application/json").
                header("Content-type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                body(User.builder()
                        .username("duotech2023")
                        .password("duotech").build()).
                when().
                log().all().
                post("/login").
                then().
                log().all().
                statusCode(200)

                .extract().path("access_token");

        PlaylistsResponse playlistsResponse = given().
                header("Accept", "application/json").
                header("Content-type", "application/json").
                header("Authorization", jwtToken).
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").

                when().
                log().all().
                get("/playlists").
                then().
                log().all().
                statusCode(200).extract().as(PlaylistsResponse.class);


        System.out.println(playlistsResponse);

        System.out.println(playlistsResponse.getPlaylists().get(0));
        System.out.println(playlistsResponse.getPlaylists().get(0).getId());

    }





}
