package org.bikeshare.model.services.loginservice;

import org.bikeshare.model.domain.Rider;
import java.sql.*;

public class LoginServiceImpl implements ILoginService {

    /**
     * Validates if the riders password matches the password in the DB
     *  @param rider contains rider's login credentials
     */

    public boolean authenticateRider(Rider rider) {

        //this needs to be updated to check the password against a DB in the future
        //return (rider.getPassword() != null);

            final String DATABASE_URL = "jdbc:mysql://localhost:3306/bike_share_DB";
            final String USER = "root";
            final String PASSWORD = "P@ssw0rd";
            String dbPass = "";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT RiderPassword FROM Rider WHERE RiderEmail = '" + rider.getEmailAddress() +"';");
                while(rs.next())
                    dbPass = rs.getString(1);
                con.close();
            }catch(Exception e){ System.out.println(e);}

            return rider.getPassword().equals(dbPass);

    }

}
