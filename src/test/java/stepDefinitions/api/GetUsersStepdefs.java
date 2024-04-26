package stepDefinitions.api;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import stepDefinitions.SharedData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetUsersStepdefs {

    SharedData sharedData;

    public GetUsersStepdefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Then("the users amount should be {int}")
    public void the_users_amount_should_be(Integer amount) {
        List<Object> list = sharedData.getResponse().path("$");

        Assert.assertEquals( (int) amount, list.size());
    }
    @Then("the response should contain a list of all users with the following fields")
    public void the_response_should_contain_a_list_of_all_users_with_the_following_fields(List<String> expectedFields) {

        Map<String, Object> map = sharedData.getResponse().jsonPath().getMap("[0]");

        Assert.assertEquals(expectedFields, new ArrayList<>(map.keySet()));


    }
}
