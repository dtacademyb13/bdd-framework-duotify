package stepDefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Then("the following recommended albums should be displayed")
    public void the_following_recommended_albums_should_be_displayed(List<String> expectedAlbums) {

        //Grab the actual album names as list and compare them

        List<String> actualAlbumNames = SeleniumUtils.getElementsText(new HomePage().getAllAlbums());

        //Sort both lists to have the correct order
        expectedAlbums =  new ArrayList<>(expectedAlbums);

        Collections.sort(expectedAlbums);
        Collections.sort(actualAlbumNames);

        Assert.assertEquals(expectedAlbums, actualAlbumNames);



    }

    @And("the user is landed on the homepage")
    public void theUserIsLandedOnTheHomepage() {


    }
}
