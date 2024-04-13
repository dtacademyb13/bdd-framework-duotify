package utilities.demo;

import utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DbUtilsTest {

    public static void main(String[] args) throws SQLException {


        DBUtils.createConnection();


        List<List<Object>> result = DBUtils.getQueryResultAsListOfLists("select * from users limit 10");

        for (List<Object> row : result) {
            System.out.println(row);
        }

        System.out.println(result.get(0).get(1));
        System.out.println(result.get(0).get(2));
        System.out.println(result.get(0).get(3));
        System.out.println(result.get(0).get(4));

        List<Map<String, Object>> result2 = DBUtils.getQueryResultListOfMaps("select * from users limit 10");

        for (Map<String, Object> row : result2) {
            System.out.println(row);
        }
        System.out.println(result2.get(0).get("username"));
        System.out.println(result2.get(0).get("firstName"));
        System.out.println(result2.get(0).get("lastName"));
        System.out.println(result2.get(0).get("email"));

        DBUtils.executeUpdate("UPDATE users SET firstName='Hercules' where id='47'");

        System.out.println(DBUtils.getQueryResultAsListOfLists("Select * from users where id='47'"));

    }
}
