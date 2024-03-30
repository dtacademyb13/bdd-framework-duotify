package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignupPage;
import utilities.Driver;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SignUpStepDefs {

    @When("The user fills up the fields with valid info")
    public void the_user_fills_up_the_fields_with_valid_info() {
         new SignupPage().signUpWithRandomData();
    }

    @When("The user fills up the fields with valid info such as {string} {string} {string} {string} {string}")
    public void the_user_fills_up_the_fields_with_valid_info_such_as(String user, String f, String l, String e, String p) {
         new SignupPage().signUp(user, f, l, e, p);
    }


    @When("The user fills up the fields with the following info")
    public void the_user_fills_up_the_fields_with_the_following_info(List<String> list) {
        new SignupPage().signUp(
                list.get(0),
                list.get(1),
                list.get(2),
                list.get(3),
                list.get(4)
        );
    }


    @When("The user fills up the fields with the following info as")
    public void the_user_fills_up_the_fields_with_the_following_info_as(Map<String, String> map) {

        new SignupPage().signUp(
                map.get("username"),
                map.get("firstName"),
                map.get("lastName"),
                map.get("email"),
                map.get("password")
        );
    }
    @Then("The user should be able to sign up successfully")
    public void the_user_should_be_able_to_sign_up_successfully() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());
    }


}
