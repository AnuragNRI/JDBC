package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestUpdate {
    public static void main(String[] args) {
        String urlMySQL = "jdbc:mysql://localhost:3306/assignment5";
        String username = "root";
        String password = "12345";
        Scanner sc = new Scanner(System.in);
        String query;
        Statement stmt;
        int x;

        try {
            Connection conSQL = DriverManager.getConnection(urlMySQL, username, password);
            
            System.out.println("Enter the id of the student whose data you want to change");
            int stuID = Integer.parseInt(sc.nextLine());

            System.out.println("Enter the column name that needs to be changes  -- name , age , address or course");
            String toBeChangedColumnName = sc.nextLine();
            // name age address course

            switch (toBeChangedColumnName) {
                case "name":
                    System.out.println("Enter the new name of the Student ");
                    String newName = sc.nextLine();
                    if (newName.isEmpty()) {
                        System.out.println("Empty name not Allowed");
                        break;
                    }
                    // update student set name = "Sahil" where id = 1001;
                    query = "update student set name =\' " + newName + "\' where id =" + stuID + ";";
                    stmt = conSQL.createStatement();
                    x = stmt.executeUpdate(query);
                    System.out.println(x + "Name updated succesfully");
                    break;

                case "age":
                    System.out.println("Enter the new age of the Student ");
                    int newAge = Integer.parseInt(sc.nextLine());
                    if (newAge <= 0) {
                        System.out.println("Wrong Input for the age");
                        break;
                    }
                    // update student set age = 21 where id = 1006;
                    query = "update student set age = " + newAge + " where id =" + stuID;
                    System.out.println(query);
                    stmt = conSQL.createStatement();
                    x = stmt.executeUpdate(query);
                    System.out.println("Age updated succesfully");
                    break;

                case "address":
                    System.out.println("Enter the new address of the Student ");
                    String newAddress = sc.nextLine();
                    if (newAddress.isEmpty()) {
                        System.out.println("Empty Address not Allowed");
                        break;
                    }
                    // update student set name = "Sahil" where id = 1001;
                    query = "update student set address =\' " + newAddress + "\' where id =" + stuID + ";";
                    stmt = conSQL.createStatement();
                    x = stmt.executeUpdate(query);
                    System.out.println(x + "Address updated succesfully");
                    break;

                case "course":
                    System.out.println("Enter the new course of the Student ");
                    int newCourse = Integer.parseInt(sc.nextLine());
                    if (newCourse < 101 || newCourse > 105) {
                        System.out.println("Wrong Input for the course");
                        break;
                    }
                    // update student set name = "Sahil" where id = 1001;
                    query = "update student set course = " + newCourse + " where id =" + stuID + ";";
                    stmt = conSQL.createStatement();
                    x = stmt.executeUpdate(query);
                    System.out.println(x + "Course updated succesfully");
                    break;

                default:
                    System.out.println("You have entered the Wrong Column name");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

}
