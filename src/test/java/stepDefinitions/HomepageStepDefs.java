package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;

public class HomepageStepDefs {

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


    @Then("the user should see {int} recommended albums")
    public void the_user_should_see_recommended_albums(Integer albumCount) {

      Integer actualCount =  new HomePage().getAllAlbums().size();

      Assert.assertEquals(albumCount, actualCount);

    }
}
