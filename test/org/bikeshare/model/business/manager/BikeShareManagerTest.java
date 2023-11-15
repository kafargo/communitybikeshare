package org.bikeshare.model.business.manager;

import junit.framework.TestCase;
import org.bikeshare.model.domain.*;
import org.bikeshare.model.services.riderservice.IRiderService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BikeShareManagerTest extends TestCase {

    private BikeShareManager bikeShareManager;
    private TripComposite tripComposite;
    private Rider rider;
    private Bike bike;
    private Waypoint waypoint;

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();

        bikeShareManager = BikeShareManager.getInstance();

        rider = new Rider("For", "Testing", "test@junit.org","password");
        bike = new Bike("abc", 2000, 100, 100, 100, false, false, BikeType.CRUISER, BikeSize.SMALL);
        waypoint = new Waypoint("Test", 0, 0, "New York", 10);

        //rider.takePossessionOfBike(testBike);
        tripComposite = new TripComposite();
        tripComposite.setRider(rider);
        tripComposite.setBike(bike);
        tripComposite.setWaypoint(waypoint);
    }


    /**
     * Test performAction method for RegisterCustomer
     */
    public final void testPerformActionOnRegisterRider()
    {
        boolean action = bikeShareManager.performAction("RegisterRider", tripComposite);
        assertTrue(action);

        /**
         * Would like to research if there is a better way to do this, but since a new user gets
         * created for this test the below deletes the user from the DB after the test is complete
         */
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/bike_share_DB";
        final String USER = "root";
        final String PASSWORD = "P@ssw0rd";
        try {
            Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            System.out.println("Deleting user ...");
            String sql = "DELETE FROM `bike_share_DB`.`Rider` WHERE (`RiderEmail` = '" +
                    tripComposite.getRider().getEmailAddress() + "');";
            stmt.executeUpdate(sql);
            System.out.println("Deleted user: " + tripComposite.getRider().getEmailAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test performAction method for LoginCustomer
     */
    public final void testPerformActionOnCheckoutBike()
    {
        boolean action = bikeShareManager.performAction("CheckoutBike", tripComposite);
        assertTrue(action);
        //tripComposite.getRider().returnBike(tripComposite.getBike());
    }

    /**
     * Test register customer
     *
     */
    public final void testRegisterRider() {
        boolean isRegistered = bikeShareManager.registerRider(IRiderService.NAME, tripComposite);
        assertTrue(isRegistered);

        /**
         * Would like to research if there is a better way to do this, but since a new user gets
         * created for this test the below deletes the user from the DB after the test is complete
         */
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/bike_share_DB";
        final String USER = "root";
        final String PASSWORD = "P@ssw0rd";
        try {
            Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            System.out.println("Deleting user ...");
            String sql = "DELETE FROM `bike_share_DB`.`Rider` WHERE (`RiderEmail` = '" +
                    tripComposite.getRider().getEmailAddress() + "');";
            stmt.executeUpdate(sql);
            System.out.println("Deleted user: " + tripComposite.getRider().getEmailAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test login customer
     */
    public final void testCheckoutBike() {
        boolean checkedOutBike = bikeShareManager.checkoutBike(IRiderService.NAME, tripComposite);
        assertTrue(checkedOutBike);
    }
}
