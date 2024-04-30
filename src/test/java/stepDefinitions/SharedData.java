package stepDefinitions;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

import static io.restassured.RestAssured.given;

@Data
public class SharedData {

    private String playlistName;
    private String username;
    private String first;
    private String last;
    private String email;
    private String pass;
    private Object fieldValue;

    private RequestSpecification requestSpecification = given(); // initialize an empty requestSpec obj
    private Response response;


    private String JWToken;






}
