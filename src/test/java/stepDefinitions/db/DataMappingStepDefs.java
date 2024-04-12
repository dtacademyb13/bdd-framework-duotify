package stepDefinitions.db;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import stepDefinitions.SharedData;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataMappingStepDefs {

    SharedData sharedData;

    public DataMappingStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }



    @Then("the data should be mapped correctly to the following columns in the {string} table:")
    public void the_data_should_be_mapped_correctly_to_the_following_columns_in_the_table(String tableName, List<String> expectedColumns) {

        StringBuilder columnNames = new StringBuilder();
        expectedColumns.forEach(s -> columnNames.append(s + ","));
        columnNames.deleteCharAt(columnNames.length()-1);

        String query = String.format("SELECT %s from %s where username='%s'",
                columnNames,
                tableName,
                sharedData.getUsername()
        );

        System.out.println(query);

        List<Map<String, Object>> queryResult = DBUtils.getQueryResultListOfMaps(query);

        System.out.println(expectedColumns);
        System.out.println(queryResult);

        Map<String, Object> map = queryResult.get(0);

        List<String> actualColumns = new ArrayList<>(map.keySet());

        Assert.assertEquals(expectedColumns, actualColumns);

    }

    @Then("the data should be mapped correctly to the following columns in the {string} table 2:")
    public void the_data_should_be_mapped_correctly_to_the_following_columns_in_the_table2(String tableName, List<String> expectedColumns) {

        StringBuilder columnNames = new StringBuilder();
        expectedColumns.forEach(s -> columnNames.append(s).append(","));
        columnNames.deleteCharAt(columnNames.length()-1);

        String query = String.format("SELECT %s from %s where owner='%s'",
                columnNames,
                tableName,
                sharedData.getUsername()
        );

        System.out.println(query);

        List<Map<String, Object>> queryResult = DBUtils.getQueryResultListOfMaps(query);

        System.out.println(expectedColumns);
        System.out.println(queryResult);

        Map<String, Object> map = queryResult.get(0);

        List<String> actualColumns = new ArrayList<>(map.keySet());

        Assert.assertEquals(expectedColumns, actualColumns);

    }


}
