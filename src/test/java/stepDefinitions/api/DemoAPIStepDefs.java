package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepDefinitions.SharedData;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class DemoAPIStepDefs {



    SharedData sharedData;

    public DemoAPIStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }



    @Given("The base uri is set")
    public void the_base_uri_is_set() {

    }


    @Given("{string} header is set to {string}")
    public void header_is_set_to(String key, String value) {

        sharedData.getRequestSpecification().header(key, value);


    }
    @Given("{string} path Parameter is set to {string}")
    public void path_parameter_is_set_to(String key, String value) {
        sharedData.getRequestSpecification().pathParam(key, value);

    }
    @Given("{string} query Parameter is set to {string}")
    public void query_parameter_is_set_to(String k, String v) {


        sharedData.getRequestSpecification(). queryParam(k, v);



    }
    @When("I send a {string} request to endpoint {string}")
    public void i_send_a_request_to_endpoint(String string, String endpoint) {
       sharedData.setResponse( sharedData.getRequestSpecification().when().   //request type
                log().all(). // log the request details
                get(endpoint));



    }
    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer expectedStatscode) {
        sharedData.getResponse().then(). //assertion
                log().all(). //log the response details
                statusCode(expectedStatscode);


    }
    @Then("response time should be less than {int} ms")
    public void response_time_should_be_less_than_ms(Integer time) {
        sharedData.getResponse().then().
                time(lessThan((long)time));
    }
}
