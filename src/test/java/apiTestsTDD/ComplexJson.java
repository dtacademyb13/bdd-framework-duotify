package apiTestsTDD;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.text.CompactNumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class ComplexJson {


    @Test

    public void basicJsonPathAndHamcrestMatcher(){

        baseURI = "https://api.github.com";

    JsonPath responseAsJsonPath=     given().
                header("Authorization" , "Bearer " + ConfigReader.getProperty("github.token")).
                header("Accept" , "application/vnd.github+json" ).
        when().log().all().
                get("/user").
        then().log().all().
                assertThat().
                statusCode(200).
               body("login", equalTo("dtacademyb13")).
               body("id", is(159500813)).
               body("login", isA(String.class)).  // checks the type of the value
               body("id", instanceOf(Integer.class)).
               body("login", not(nullValue())). // not() is used to negate any method
               body("login", notNullValue()). // not null
               body("company", nullValue()). //null
               body("plan", hasKey("name")). // checks if a map contains key
               body("plan", hasKey("space")). // checks if a map contains key
               body("plan", hasKey("collaborators")). // checks if a map contains key
               body("plan", allOf(hasKey("name"), hasKey("space"), hasKey("collaborators"))). // checks if a map contains all the given keys
               body("plan", anyOf(hasKey("name"), hasKey("space"), hasKey("collaborators"))). // checks if a map contains any of the given keys
               body("$", hasKey("login")). // checks if a map contains key
               body("", hasKey("id")). // "" or $ returns the root element, it could be json or an array
               body("$", hasKey("id")). //
               body("$", hasValue("dtacademyb13")). //  verifies the value
               body("$", hasEntry("login", "dtacademyb13")). //
               body("$", hasEntry("id", 159500813)). //
               body("$", not(equalTo(Collections.EMPTY_MAP))). // checks if the map is not empty
               extract().jsonPath();
//               extract().response();



          List<String> planFieldKeys = List.of("name", "space", "collaborators", "private_repos" );


        Map<String, Object> plan = responseAsJsonPath.getMap("plan");

        System.out.println(plan);

        Assert.assertEquals(new ArrayList<>(plan.keySet()), planFieldKeys);


    }


    @Test
    public void basicJsonPathAndHamcrestMatcher2() {

        baseURI = "https://api.github.com";

        JsonPath jsonPath = given().
//        Response response = given().
                header("Accept", "application/vnd.github+json").
                when().log().all().
                get("/users").
                then().log().all().
                statusCode(200).
                body("$", hasSize(30)).
                body("[1]", hasEntry("id", 2)).
                body("[1].login", equalTo("defunkt")).
                extract().jsonPath();
//               extract().response();

       // String path = response.path("[1].login");

        List<Map<String, Object>> rootelement = jsonPath.getList(""); // "" or $ to obtain the root array

        System.out.println(rootelement);

        // Obtain the second element of this array of jsons
        Map<Object, Object> secondJson = jsonPath.getMap("[1]"); //to access root array elements simply indicate the index

        System.out.println(secondJson);

        String loginOfSecondJson = jsonPath.getString("[1].login");

        System.out.println(loginOfSecondJson);


    }

    @Test
    public void workWithComplexJsonResponse(){

        baseURI = "https://api.github.com";

        JsonPath jsonPath = given().
                header("Accept", "application/vnd.github+json").
                header("Authorization", "Bearer ghp_hzHIS651FwZRsomWd5iR5oxEqTPZhF07UUQReplaced").
                pathParam("username", "martamay").
                when().log().all().
                get("/users/{username}/events").
                then().log().all().
                statusCode(200).
                extract().jsonPath();

        String type = jsonPath.getString("[0].type");
        System.out.println(type);

        String actor = jsonPath.getString("[0].actor.login");
        System.out.println(actor);

        String email = jsonPath.getString("[2].payload.commits[0].author.email");
        System.out.println(email);

        List<String> emails = jsonPath.getList("[2].payload.commits.author.email");
        System.out.println(emails);

        List<String> types = jsonPath.getList("type");
        System.out.println(types);






    }
}
