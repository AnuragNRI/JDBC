package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class TestRead {
    public static void main(String[] args) {
        String urlMySQL = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "12345";

        try {
            Connection conSQL = DriverManager.getConnection(urlMySQL, username, password);
            System.out.println("Connection Successful");
            String query = "select first_name,last_name , email , phone_number from employees";
            Statement stmt = conSQL.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                String fName = rs.getString(1);
                String lName = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);

                System.out.println(fName + "--" + lName+"--" + email+ "--" + phone);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
