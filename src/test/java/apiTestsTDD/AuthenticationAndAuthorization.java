package apiTestsTDD;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AuthenticationAndAuthorization {



    @Test
    public void basicAuth(){

        RestAssured.baseURI = "https://postman-echo.com";
        given().
                auth().
                basic("postman", "password").
           when().  log().all().
                get("/basic-auth").
                then().log().all().statusCode(200);

    }

}
