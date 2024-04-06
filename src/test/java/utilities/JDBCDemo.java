package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {

    public static void main(String[] args) throws SQLException {


        String url = "jdbc:mysql://database-1.cb72canasobc.us-east-2.rds.amazonaws.com/sakila";
        String user = ConfigReader.getProperty("db.username");
        String password = ConfigReader.getProperty("db.password");
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


//        statement.executeUpdate("update film set title='FORGOTTEN MEMORY' where film_id='1'");

        ResultSet resultSet = statement.executeQuery("SELECT * from film");

        statement.executeUpdate("UPDATE film SET title='FORGOTTEN MEMORY' where film_id='1'");

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        System.out.println(columnCount);
        System.out.println(metaData.getColumnName(2));
        List<String> columnNames = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }


        System.out.println(columnNames);
//        resultSet.next();
//        System.out.println(resultSet.getString(2));
//        System.out.println(resultSet.getString("title"));

//        List<String> filmsTitles = new ArrayList<>();
//
//        while(resultSet.next()){
//            filmsTitles.add(resultSet.getString("title"));
//        }
//
//        System.out.println(filmsTitles);

        resultSet.absolute(5); //Moves the cursor to the given row number in this ResultSet object.
        System.out.println(resultSet.getString("title") + ", " + resultSet.getString("description"));
        resultSet.beforeFirst(); //Moves the cursor to the front of this ResultSet object, just before the first row
        resultSet.first();
     int currenrowNo = resultSet.getRow(); //Retrieves the current row number. The first row is number 1, the second number 2, and so on.
        System.out.println(currenrowNo);
        resultSet.last(); //Moves the cursor to the last row
        int rowCount = resultSet.getRow();
        System.out.println(rowCount);
//        resultSet.afterLast();// Moves the cursor to the end of this ResultSet object, just after the last row
//
//
//
//

        resultSet.close();
        statement.close();
        connection.close();






    }
}
