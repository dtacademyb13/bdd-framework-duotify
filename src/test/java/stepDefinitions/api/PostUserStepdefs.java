package stepDefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import stepDefinitions.SharedData;

public class PostUserStepdefs {



    SharedData sharedData;

    public PostUserStepdefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @And("the request body is set to the following payload")
    public void theRequestBodyIsSetToTheFollowingPayload(String docString) {
        Faker faker = new Faker();
        sharedData.getRequestSpecification().body(

               String.format(docString,
                       faker.name().username(),
                       faker.name().firstName(),
                       faker.name().lastName(),
                       faker.internet().emailAddress(),
                       faker.internet().password())
        );
    }
}
