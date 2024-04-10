package stepDefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.UserDetailsPage;
import utilities.ConfigReader;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDetailsStepDefs {
    String email;
    @When("the user updates the email")
    public void theUserUpdatesTheEmail() throws InterruptedException {

        HomePage homePage = new HomePage();

        homePage.getUsername().click();
        homePage.getUserDetailsButton().click();

        UserDetailsPage userDetailsPage = new UserDetailsPage();

        email =new Faker().internet().emailAddress();
        userDetailsPage.updateEmail(email);


    }

    @Then("the success message should be displayed")
    public void theSuccessMessageShouldBeDisplayed() {

        Assert.assertTrue(new UserDetailsPage().getSuccessMessage().isDisplayed());

    }


    @And("the user's email should be correctly updated in the database")
    public void theUserSEmailShouldBeCorrectlyUpdatedInTheDatabase() {

        String query = "SELECT email from users where username='"+ ConfigReader.getProperty("username") + "'";

        String formattedQuery = String.format("SELECT email from users where username='%s'", ConfigReader.getProperty("username"));




        System.out.println(query);
        System.out.println(formattedQuery);
        List<Map<String, Object>> result = DBUtils.getQueryResultListOfMaps(formattedQuery);

        Map<String, Object> map = result.get(0);

        Assert.assertEquals( email, map.get("email"));
    }


    @Given("the user email is updated in the db")
    public void the_user_email_is_updated_in_the_db() throws SQLException {

        email =new Faker().internet().emailAddress();
        String query = String.format("UPDATE users SET email='%s' where username='%s'",
                email, ConfigReader.getProperty("username"));
        System.out.println(query);
        DBUtils.executeUpdate(query);

    }
    @Then("the updated user email should be correct")
    public void the_updated_user_email_should_be_correct() throws InterruptedException {

        new HomePage().clickOnLink("Duotech Academy");
        new HomePage().getUserDetailsButton().click();
        Thread.sleep(2000);
        String actualEmailonUI = new UserDetailsPage().getEmailField().getAttribute("value");
        Assert.assertEquals(email, actualEmailonUI);


    }
}
