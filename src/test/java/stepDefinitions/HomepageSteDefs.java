package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;

public class HomepageSteDefs {

    @Then("the user should see the homepage links")
    public void the_user_should_see_the_homepage_links() {
        for (WebElement e : new HomePage().getLinks()) {
            Assert.assertTrue(e.isDisplayed());
        }
    }

    @Then("the user should see the welcome message")
    public void the_user_should_see_welcome() {
         Assert.assertTrue(new HomePage().getWelcomeMessage().isDisplayed());
    }

}
