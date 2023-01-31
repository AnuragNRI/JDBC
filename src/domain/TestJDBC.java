package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        String urlMySQL = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "12345";

        try {
            Connection conSQL = DriverManager.getConnection(urlMySQL, username, password);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
