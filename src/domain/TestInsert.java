package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestInsert {
    public static void main(String[] args) {
        String urlMySQL = "jdbc:mysql://localhost:3306/assignment5";
        String username = "root";
        String password = "12345";
        Scanner sc = new Scanner(System.in);

        try {
            Connection conSQL = DriverManager.getConnection(urlMySQL, username, password);


            System.out.println("Insert a new Row in the Table Student ------");

            int i = 0;
            boolean checked = true;

            while (i < 5 && checked) {
                System.out.println("Enter the name of the Student");
                String fullName = sc.nextLine();
                System.out.println("Enter the age of the Student");
                int stuAge = Integer.parseInt(sc.nextLine());
                System.out.println("Enter the Address of the Student");
                String stuAddress = sc.nextLine();
                System.out.println("Enter the course the Student want's to enroll in");
                int courseEnrolled = Integer.parseInt(sc.nextLine());

                String query = "insert into student( name , age ,address, course) values(\'" + fullName + "\'," + stuAge
                        + ",\'" + stuAddress + "\'," + courseEnrolled + ");";

                Statement stmt = conSQL.createStatement();
                int x = stmt.executeUpdate(query);
                System.out.println("Record insered succesfully");

                String response = "";
                System.out.println("Do you want to Insert Another Row");
                response = sc.nextLine();

                if (response.equals("no")) {
                    checked = false;
                } else
                    continue;

                i++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

