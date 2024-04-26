package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import stepDefinitions.SharedData;

import static io.restassured.RestAssured.given;

public class DeleteUserStepDefs {


    SharedData sharedData;

    public DeleteUserStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Then("the response body {string} value is stored")
    public void the_response_body_value_is_stored(String string) {
       sharedData.setFieldValue( sharedData.getResponse().path("user_id") );
    }
    @Then("the request specification is reset")
    public void the_request_specification_is_reset() {
          sharedData.setRequestSpecification(given()); //resets the RequestSpec object to an empty one
    }
    @Given("the request {string} query parameter is set to the stored value")
    public void the_request_query_parameter_is_set_to_the_stored_value(String key) {
        sharedData.getRequestSpecification().queryParam(key,sharedData.getFieldValue());
    }
}
