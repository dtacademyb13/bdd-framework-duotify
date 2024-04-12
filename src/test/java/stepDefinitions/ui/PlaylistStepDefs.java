package stepDefinitions.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.PlaylistDetailsPage;
import pages.PlaylistsPage;
import stepDefinitions.SharedData;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class PlaylistStepDefs {


    SharedData sharedData;

    public PlaylistStepDefs(SharedData sharedData){
        this.sharedData = sharedData;
    }

String playlistName;
    @When("the user creates a new playlist with a name {string}")
    public void theUserCreatesANewPlaylistWithAName(String name) throws InterruptedException {
        sharedData.setPlaylistName(name);
        sharedData.setUsername(ConfigReader.getProperty("username"));
        new HomePage().clickOnLink("Your Music");
        new PlaylistsPage().createPlaylist(name);
        Thread.sleep(2000);

    }

    @Then("the playlist should be created in the db")
    public void thePlaylistShouldBeCreatedInTheDb() {

        String query = String.format("SELECT name FROM playlists where owner='%s' and name='%s'",
                ConfigReader.getProperty("username"), playlistName);

        System.out.println(query);
        List<Map<String, Object>> queryResultListOfMaps = DBUtils.getQueryResultListOfMaps(query);
        System.out.println(queryResultListOfMaps);
        Assert.assertTrue(!queryResultListOfMaps.isEmpty());
    }

    @When("the user deletes the playlist with a name {string}")
    public void theUserDeletesThePlaylistWithAName(String name) throws InterruptedException {

        new PlaylistsPage().clickOnPlaylist(name);
        new PlaylistDetailsPage().deletePlaylist();

    }

    @Then("the playlist should be deleted in the db")
    public void thePlaylistShouldBeDeletedInTheDb() {

        String query = String.format("SELECT name FROM playlists where owner='%s' and name='%s'",
                ConfigReader.getProperty("username"), playlistName);

        System.out.println(query);
        List<Map<String, Object>> queryResultListOfMaps = DBUtils.getQueryResultListOfMaps(query);
        System.out.println(queryResultListOfMaps);
        Assert.assertTrue(queryResultListOfMaps.isEmpty());
    }


    @Then("the user should not see the same playlist")
    public void the_user_should_not_see_playlist() throws InterruptedException {
        new HomePage().clickOnLink("Your Music");
        List<WebElement> allPlaylists = new PlaylistsPage().getAllPlaylists();
        System.out.println("Wait for 1 sec");
        Thread.sleep(1000);
        System.out.println("Grabbing the text...");
        List<String> elementsText = SeleniumUtils.getElementsText(allPlaylists);
        System.out.println("Checking the list for the playlist text...");
        Assert.assertFalse(elementsText.contains(sharedData.getPlaylistName()));

    }


}
