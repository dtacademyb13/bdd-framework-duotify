package stepDefinitions.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.AlbumDetailsPage;
import pages.HomePage;

import java.util.List;
import java.util.Map;

public class AlbumStepDefs {

    @When("the user clicks on the album {string}")
    public void the_user_clicks_on_the_album(String albumName) {
          new HomePage().clickOnAlbum(albumName);
    }
    @Then("the album details should be the following")
    public void the_album_details_should_be_the_following(Map<String,String> expectedDataAsMap) {

        AlbumDetailsPage albumDetailsPage = new AlbumDetailsPage();

        String actualAlbumName = albumDetailsPage.getAlbumName().getText();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualAlbumName).isEqualTo(expectedDataAsMap.get("name"));
        softAssertions.assertThat(albumDetailsPage.getAuthor().getText().substring(3)).isEqualTo(expectedDataAsMap.get("author"));
        softAssertions.assertThat(albumDetailsPage.getSongCount().getText().split(" ")[0] ).isEqualTo(expectedDataAsMap.get("songCount"));

        softAssertions.assertAll();
//        Assert.assertEquals(expectedDataAsMap.get("name"),actualAlbumName);
//        Assert.assertEquals(expectedDataAsMap.get("author"),albumDetailsPage.getAuthor().getText().substring(3));
//        Assert.assertEquals(expectedDataAsMap.get("songCount"),albumDetailsPage.getSongCount().getText().split(" ")[0]);



    }

    @Then("the album should have the following info")
    public void the_album_should_have_the_following_info( List<Map<String, String>> expectedData) {

        AlbumDetailsPage albumDetailsPage = new AlbumDetailsPage();

        String actualAlbumName = albumDetailsPage.getAlbumName().getText();
        Assert.assertEquals(expectedData.get(0).get("name"),actualAlbumName);
        Assert.assertEquals(expectedData.get(0).get("author"),albumDetailsPage.getAuthor().getText().substring(3));
        Assert.assertEquals(expectedData.get(0).get("songCount"),albumDetailsPage.getSongCount().getText().split(" ")[0]);

    }


//    @Given("I have some pre-requisites")
//    public void i_have_some_pre_requisites() {
////        throw new io.cucumber.java.PendingException();
//    }
}
