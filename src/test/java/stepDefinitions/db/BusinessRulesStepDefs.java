package stepDefinitions.db;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class BusinessRulesStepDefs {

    @Then("{string} column for {string} table should have the following:")
    public void column_for_table_should_have_the_following(String column, String table, List<String> expectedGenres) {

        List<List<Object>> queryResultListOfLists =
                DBUtils.getQueryResultAsListOfLists(String.format("SELECT %s from %s", column, table));

        List<String> actualGenres = DBUtils.getColumnData(queryResultListOfLists, 0);

        Assert.assertEquals(expectedGenres, actualGenres);

    }
}
