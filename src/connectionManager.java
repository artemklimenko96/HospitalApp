package application;

import java.sql.*;

/**
 * Created by Artem Klimenko on 13 Jan 2017.
 */
public class connectionManager {

    private static String url = "jdbc:mysql://localhost:3306/hospital";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "";
    private static Connection conn;


    public static Connection getConnection() {
        try {

            Class.forName(driverName); //This loads the MySQL driver. Each DB has it's own driver
            try {
                conn = DriverManager.getConnection(url, username, password); //Set the connection up
            } catch (SQLException ex) {
                // log an exception
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception
            System.out.println("Driver not found.");
        }
        return conn;

    }

    public static ResultSet runMyQuery(Statement statement, Connection connection, String query){
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();  //Usage of statement makes your code prone to SQL injection attacks
            resultSet = statement
                    .executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;


    }

    public static void writeData(ResultSet resultSet) throws SQLException {
        //         Now get some data from the database
        // Result set get the result of the SQL query

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        for (int i = 1; i <= columnsNumber; i++){

            System.out.print(rsmd.getColumnName(i)+",\t");
            if(i==columnsNumber)
            {
                System.out.print("\r\n");
            }

        }


        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = resultSet.getString(i);
                System.out.print(columnValue + " " );
            }
            System.out.println("");
        }
    }
}
