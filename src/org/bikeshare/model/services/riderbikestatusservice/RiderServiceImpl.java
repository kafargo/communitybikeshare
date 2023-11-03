package org.bikeshare.model.services.riderbikestatusservice;

import org.bikeshare.model.domain.Bike;
import org.bikeshare.model.domain.Rider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RiderServiceImpl implements IRiderService {

    /**
     * Checks to see if the Rider has a Bike.
     *  @param rider contains rider details
     */
    @Override
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

    /**
     * The below method adds a bike to the rider
     * @param rider
     * @param bike
     * @return boolean which represents if it succeeded or not
     */
    @Override
    public boolean addBikeToRider(Rider rider, Bike bike) {
        if(!rider.getHasBike()){
            rider.takePossessionOfBike(bike);
            return true;
        }
        else return false;
    }

    /**
     * The below method is for the rider to drop off the bike
     * @param rider
     * @return boolean which represents if it succeeded or not
     */
    @Override
    public boolean returnRidersBike(Rider rider) {
        if(rider.getHasBike()){
            rider.returnBike(rider.getBike());
            return true;
        }
        else return false;
    }

    /**
     * This is a simple method to update the Riders name
     * @param newFirstName
     * @param newLastName
     * @param rider
     * @return boolean which represents if it succeeded or not
     */
    @Override
    public boolean updateRiderName(String newFirstName, String newLastName, Rider rider) {
        rider.setFirstName(newFirstName);
        rider.setLastName(newLastName);
        return true;
    }

}
