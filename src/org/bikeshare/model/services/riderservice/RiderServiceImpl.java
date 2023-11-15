package org.bikeshare.model.services.riderservice;

import org.bikeshare.model.domain.Bike;
import org.bikeshare.model.domain.Rider;
import org.bikeshare.model.domain.TripComposite;
import org.bikeshare.model.services.exceptions.RiderCheckinException;
import org.bikeshare.model.services.exceptions.RiderCheckoutException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;


public class RiderServiceImpl implements IRiderService {

    /**
     * Checks to see if the Rider has a Bike.
     *  @param rider contains rider details
     */
    @Override
    public boolean checkIfRiderHasBike(Rider rider){
        return rider.getHasBike();
    }

    /**
     * The below method adds a bike to the rider
     * @param rider
     * @param bike
     * @return boolean which represents if it succeeded or not
     */
    @Override
    public boolean checkoutBike(Rider rider, Bike bike) throws RiderCheckoutException {
        if(!rider.getHasBike()){
            rider.takePossessionOfBike(bike);
            bike.getWaypoint().removeBike(bike);

            return true;
        }
        else throw new RiderCheckoutException("Rider already has a bike");
    }

    @Override
    public boolean checkoutBike(TripComposite tripComposite) throws RiderCheckoutException {
        if(!tripComposite.getRider().getHasBike()){
            tripComposite.getRider().takePossessionOfBike(tripComposite.getBike());
            tripComposite.getWaypoint().removeBike(tripComposite.getBike());
            return true;
        }
        else throw new RiderCheckoutException("Rider already has a bike");
    }

    /**
     * The below method is for the rider to drop off the bike
     * @param rider
     * @return boolean which represents if it succeeded or not
     */
    @Override
    public boolean returnRidersBike(Rider rider) throws RiderCheckinException {
        if(rider.getHasBike()){
            rider.returnBike(rider.getBike());
            return true;
        }
        else{
            throw new RiderCheckinException("This rider has no bike to checkin");
        }
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

    /**
     * This is a simple method to update the Riders name
     * @param tripComposite
     * @return boolean which represents if it succeeded or not
     */
    @Override
    public boolean registerNewRider(TripComposite tripComposite) {

        //the below code only checks that the email does not already exist in the DB, but does not actually add the rider

        final String DATABASE_URL = "jdbc:mysql://localhost:3306/bike_share_DB";
        final String USER = "root";
        final String PASSWORD = "P@ssw0rd";
        String dbEmail = "";
        boolean emailInUse = true;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT RiderEmail FROM Rider WHERE RiderEmail = '" + tripComposite.getRider().getEmailAddress() +"';");
            while(rs.next())
                dbEmail = rs.getString(1);
            con.close();
        }catch(Exception e){ System.out.println(e);}

        emailInUse = tripComposite.getRider().getEmailAddress().equals(dbEmail);
        //if that email is not found in the DB, the rider can get registered.


        if(!emailInUse){
            try {
                Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                // Execute a query
                System.out.println("Inserting records into the table...");
                String sql = "INSERT INTO Rider (RiderEmail, RiderFirstName, RiderLastName, RiderPassword) " +
                        "VALUES ('" +
                        tripComposite.getRider().getEmailAddress() + "', '" +
                        tripComposite.getRider().getFirstName() + "', '" +
                        tripComposite.getRider().getLastName() + "', '" +
                        tripComposite.getRider().getPassword() + "')";
                stmt.executeUpdate(sql);
                System.out.println("Inserting user: " + tripComposite.getRider().getEmailAddress());
                System.out.println("Inserted records into the table...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return !emailInUse;
    }

}
