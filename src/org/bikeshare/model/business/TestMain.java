package org.bikeshare.model.business;

import org.bikeshare.model.domain.Rider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestMain {

    public static void main(String[] args) {

        Rider rider = new Rider("Simpson", "Homer", "Homer@test.org","password");

        final String DATABASE_URL = "jdbc:mysql://localhost:3306/bike_share_DB";
        final String USER = "root";
        final String PASSWORD = "P@ssw0rd";
        String dbReturn = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Rider WHERE RiderEmail = '" + rider.getEmailAddress() + "';");
            while (rs.next())
                dbReturn = rs.getString(3);
                System.out.println(rs.next());
                System.out.println(dbReturn);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

//        String sql = "INSERT INTO Rider (RiderEmail, RiderFirstName, RiderLastName, RiderPassword) " +
//                "VALUES ('" +
//                rider.getEmailAddress() + "', '" +
//                rider.getFirstName() + "', '" +
//                rider.getLastName() + "', '" +
//                rider.getPassword() + "')";
//        System.out.println(sql);

        try {
            Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO Rider (RiderEmail, RiderFirstName, RiderLastName, RiderPassword) " +
                "VALUES ('" +
                rider.getEmailAddress() + "', '" +
                rider.getFirstName() + "', '" +
                rider.getLastName() + "', '" +
                rider.getPassword() + "')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
