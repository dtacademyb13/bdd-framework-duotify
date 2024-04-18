package stepDefinitions.db;

import io.cucumber.java.en.When;
import stepDefinitions.SharedData;
import stepDefinitions.ui.ExampleStepdefs;

public class DBExampleStepDefs {

    SharedData sharedData;

    public DBExampleStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @When("I retrieve the same user with the username from the db")
    public void iRetrieveTheSameUserWithTheUsernameFromTheDb() {

        String query = "SELECT * from users where username="+sharedData.getUsername()+"";


    }
}
