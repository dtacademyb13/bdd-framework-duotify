package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class ExampleStepdefs {


    @Given("I have {int} cucumbers in my belly")
    public void iHaveCucumbersInMyBelly(Integer noOfCukes) {
        System.out.println("I ate " + noOfCukes + " cucumbers");
    }

    @Given("I also have {long} tomatoes")
    public void i_also_have_tomatoes(Long int1) {
        System.out.println(int1);
    }
    @Given("I have a cucumber of type {string}")
    public void i_have_a_cucumber_of_type(String string) {
        System.out.println(string);
    }
    @When("I add {double} more")
    public void i_add_more(Double double1) {
        System.out.println(double1);
    }
    @Then("I should have {double} cucumbers")
    public void i_should_have_cucumbers(Double double1) {
        System.out.println(double1);
    }
    @Then("I should have also have some {word}")
    public void i_should_have_also_have_some_squashes(String word) {
        System.out.println(word);
    }

    @Then("I ate some/no banana(s)")
    public void i_ate_some_bananas() {

    }

    @Then("I pass this SQL query")
    public void i_pass_this_sql_query(String docString) {
        System.out.println(docString);
    }



    @When("I pass the following user information")
    public void i_pass_the_following_user_information(List<String> dataTable) {
        System.out.println(dataTable);

    }

    @When("I pass the following user information map")
    public void iPassTheFollowingUserInformationMap(Map<String,String> map) {

        System.out.println(map);
    }

    @When("I pass the following user information list of lists")
    public void i_pass_the_following_user_information_list_of_lists(List<List<String>> dataTable) {
        System.out.println(dataTable.get(0)); // [Annie M. G., Schmidt, 1911-03-20]
        System.out.println(dataTable.get(0).get(1)); // Schmidt
        System.out.println(dataTable.get(2).get(2)); // 1907-11-14

        System.out.println(dataTable);
    }

    @When("I pass the following user information list of maps")
    public void i_pass_the_following_user_information_list_of_maps(List<Map<String,String>> dataTable) {
        System.out.println(dataTable);
    }


    @When("I pass the following user information map with value as list")
    public void i_pass_the_following_user_information_map_with_value_as_list(Map<String, List<String>> dataTable) {
        System.out.println(dataTable);
        System.out.println(dataTable.get("323-43-4343"));
        System.out.println(dataTable.get("323-43-4343").get(1));
    }

    @When("I pass the following user information as a list")
    public void i_pass_the_following_user_information_as_a_list(List<String> dataTable) {
        System.out.println(dataTable);
    }

}
