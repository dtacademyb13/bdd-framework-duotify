package stepDefinitions.api;

import io.cucumber.java.en.And;
import org.junit.Assert;
import stepDefinitions.SharedData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.*;

public class GetPlaylistsStepDefs {


    SharedData sharedData;

    public GetPlaylistsStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @And("the request body is set to the following payload as")
    public void theRequestBodyIsSetToTheFollowingPayloadAs(String payload) {

        sharedData.getRequestSpecification().body(payload);

    }

    @And("the JWT token from the response is stored")
    public void theJWTTokenFromTheResponseIsStored() {

        String accessToken = sharedData.getResponse().path("access_token");

        System.out.println(accessToken);

        sharedData.setJWToken(accessToken);
    }


    @And("the JWT token is set in the header")
    public void theJWTTokenIsSetInTheHeader() {

        sharedData.getRequestSpecification().header(
                "Authorization", sharedData.getJWToken()
        );
    }


    @And("the id field in all playlists should not be null")
    public void theIdFieldInAllPlaylistsShouldNotBeNull() {

        List<String> list = sharedData.getResponse().jsonPath().getList("playlists.id");
        System.out.println(list);
        Assert.assertTrue(!list.contains(null));

//
    }

    @And("the owner field in all playlists should be {string}")
    public void theOwnerFieldInAllPlaylistsShouldBe(String expected) {
        List<String> list = sharedData.getResponse().jsonPath().getList("playlists.owner");
        System.out.println(list);

        list.forEach(e -> Assert.assertEquals(expected, e));

        Set<String> uniqueSet
                = new HashSet<>(list);
        System.out.println(uniqueSet);
        Assert.assertTrue(uniqueSet.size()==1 && uniqueSet.iterator().next().equals(expected));



    }
}
