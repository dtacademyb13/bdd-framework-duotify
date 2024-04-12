package stepDefinitions.db;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import stepDefinitions.SharedData;
import utilities.ConfigReader;
import utilities.DBUtils;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class CrudOperationsStepDefs {


    SharedData sharedData;

    public CrudOperationsStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("the a new playlist is created for the test user in the DB")
    public void the_a_new_playlist_is_created_for_the_test_user_in_the_db() throws SQLException {

        sharedData.setPlaylistName(new Faker().lorem().word()); // initializes the shared data
        String query = String.format("INSERT INTO playlists (name, owner, dateCreated)\n" +
                "VALUES            ('%s', '%s', '%s')",
                sharedData.getPlaylistName(), //retrieves
                ConfigReader.getProperty("username"),
                LocalDateTime.now()
                );

        System.out.println(query);
        DBUtils.executeUpdate(query);


    }

    @When("the same playlist is deleted in the database")
    public void the_same_playlist_is_deleted_in_the_database() throws SQLException {

        String query = String.format("DELETE from playlists where name='%s'",
                sharedData.getPlaylistName()); // retrieves the shared playlist name in the previous step
        System.out.println(query);
        DBUtils.executeUpdate(query);



    }





}
