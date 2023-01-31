package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class TestDelete {
    public static void main(String[] args) {
        String urlMySQL = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "12345";

        try {
            Connection conSQL = DriverManager.getConnection(urlMySQL, username, password);
            System.out.println("Connection Successful");
            String query = "update student set name = 'Anurag' where name = 'Kluzner';";
            Statement stmt = conSQL.createStatement();
            int x = stmt.executeUpdate(query);
            System.out.println(x + "record insered succesfully");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
