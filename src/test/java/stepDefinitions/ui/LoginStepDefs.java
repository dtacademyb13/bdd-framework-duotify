package stepDefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LoginStepDefs {


    @Given("the user is on the login page")
    public void theUserIsOnTheHomepage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("the user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword() {
          new LoginPage().login();
    }


    @Then("the user should be directed to the personal dashboard")
    public void theUserShouldBeDirectedToThePersonalDashboard() {

        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());

    }


    @When("the user enters invalid username and password")
    public void the_user_enters_invalid_username_and_password() {

         new LoginPage().login("duotech2023", "duotech" );
        throw new RuntimeException("fail");
    }
    @Then("the user should not be directed to the personal dashboard")
    public void the_user_should_not_be_directed_to_the_personal_dashboard() {
        Assert.assertNotEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());

    }


    @When("^the user enters no username and password$") // regular expression
    public void the_user_enters_no_username_and_password() {
        new LoginPage().login("", "" );
    }




    @When("the user enters valid username as {string} and password as {string}") // cucumber expressions
    public void theUserEntersValidUsernameAsAndPasswordAs(String username, String pass) {
        new LoginPage().login(username, pass);
    }


    @And("The user clicks on the sign up link")
    public void theUserClicksOnTheSignUpLink() {
        new LoginPage().getSignUpLink().click();
    }


    public static void main(String[] args) {



    }

    String username;
    String password;
    @Given("the user with random credentials is created in the db")
    public void the_user_with_random_credentials_is_created_in_the_db() throws SQLException {

        Faker faker = new Faker();
         username  = faker.name().username();
         password = faker.internet().password();
        String query = String.format("INSERT INTO users (username, firstName, lastName, email, password, signUpDate, profilePic)\n" +
                        "VALUES            ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                username,
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                DigestUtils.md5Hex(password),
                LocalDateTime.now(),
                "assets/images/profile-pics/head_"
        );

        System.out.println(query);



        DBUtils.executeUpdate(query);

    }
    @When("the user enters the same credentials")
    public void the_user_enters_the_same_credentials() {

          new LoginPage().login(username, password);
    }
}