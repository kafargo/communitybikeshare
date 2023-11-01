package org.bikeshare.model.services.riderbikestatusservice;

import org.bikeshare.model.domain.Rider;
import org.bikeshare.model.services.loginservice.LoginServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RiderBikeStatusServiceImpl implements IRiderBikeStatusService{

    /**
     * Checks to see if the Rider has a Bike.
     *  @param rider contains rider details
     */
    public boolean checkIfRiderHasBike(Rider rider){
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/BikeShareDB";
        final String USER = "BikeShareApp";
        final String PASSWORD = "Test123";
        int bikeStatus = 2;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT HasBike FROM Rider WHERE Email = '" + rider.getEmailAddress() +"';");
            while(rs.next())
                bikeStatus = rs.getInt(1);
            con.close();
        }catch(Exception e){ System.out.println(e);}

        return (bikeStatus == 1);
    }

}
