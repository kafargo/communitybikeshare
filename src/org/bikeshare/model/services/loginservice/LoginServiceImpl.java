package org.bikeshare.model.services.loginservice;

import org.bikeshare.model.domain.Rider;
import java.sql.*;

public class LoginServiceImpl implements ILoginService {

    /**
     * Validates if the riders password matches the password in the DB
     *  @param Rider contains rider's login credentials
     */

    public boolean authenticateRider(Rider rider) {
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/BikeShareDB";
        final String USER = "BikeShareApp";
        final String PASSWORD = "Test123";
        String dbPass = "";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT Password FROM Rider WHERE Email = '" + rider.getEmailAddress() +"';");
                while(rs.next())
                    dbPass = rs.getString(1);
                con.close();
            }catch(Exception e){ System.out.println(e);}

        return rider.getPassword().equals(dbPass);
    }

    public static void main(String[] args){

        LoginServiceImpl login = new LoginServiceImpl();
        Rider bill = new Rider("test@test.com", "test123");
        System.out.println(login.authenticateRider(bill));

    }


}
