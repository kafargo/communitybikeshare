package org.bikeshare.model.services.riderservice;

import org.bikeshare.model.business.exception.ServiceLoadException;
import org.bikeshare.model.domain.*;
import org.bikeshare.model.services.exceptions.RiderCheckinException;
import org.bikeshare.model.services.exceptions.RiderCheckoutException;
import org.bikeshare.model.services.factory.ServiceFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.Assert.*;

public class RiderServiceTest {

        Rider riderWithBike;
        Rider riderWithoutBike;
        Bike testBike;
        RiderServiceImpl riderService;

    /**
     * void assertEquals(boolean expected,boolean actual): checks that two primitives/objects are equal. It is overloaded.
     * void assertTrue(boolean condition): checks that a condition is true.
     * void assertFalse(boolean condition): checks that a condition is false.
     * void assertNull(Object obj): checks that object is null.
     * void assertNotNull(Object obj): checks that object is not null.
     */


    @Before
        public void setUp() {

            testBike = new Bike("abc", 2000, 100, 100, 100, false, false, BikeType.CRUISER, BikeSize.SMALL);
            riderWithBike = new Rider("Yes", "Bike", "test@tester.com", true, testBike);
            riderWithoutBike = new Rider("No", "Bike", "test@testme.com", "test");
            riderService = new RiderServiceImpl();

        }

        /**
         * Various tests for the RiderService
         */
        @Test
        public void testRiderServiceBikeStatusResult() {
            assertTrue(riderService.checkIfRiderHasBike(riderWithBike));
        }

        @Test
        public void testRiderServiceAddBikeToRider() {
            try{
                riderService.checkoutBike(riderWithBike, testBike);
            }catch (RiderCheckoutException e){
                assertEquals(e.getMessage(), "Rider already has a bike");
            }
            //assertEquals(false,riderService.addBikeToRider(riderWithBike, testBike));
        }

        @Test
        public void testRiderServiceReturnRidersBike(){
            try{
                riderService.returnRidersBike(riderWithoutBike);
            }catch (RiderCheckinException e){
                assertEquals(e.getMessage(), "This rider has no bike to checkin");
            }
            try {
                assertEquals(true,riderService.returnRidersBike(riderWithBike));
            } catch (RiderCheckinException e) {
                throw new RuntimeException(e);
            }
        }

        @Test
        public void testRiderServiceUpdateRiderName() {
            riderService.updateRiderName("real", "name", riderWithoutBike);
            assertEquals("real",riderWithoutBike.getFirstName());
            assertEquals("name",riderWithoutBike.getLastName());
        }

        @Test
        public void testRiderRegistrationService() {

            Rider rider = new Rider("For", "Testing", "test@junit.org","password");
            TripComposite tripComposite = new TripComposite();
            tripComposite.setRider(rider);

            assertTrue(riderService.registerNewRider(tripComposite));

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
        @Test
        public void testRiderService() {

            //
            // USE THIS APPROOACH OF CASTING TO AN INTERFACE
            //
            // Here we are casting Factory output to IRiderService, which
            // means that riderService will only see methods declared in
            // the interface and implemented by RiderServiceImpl
            //
            IRiderService riderService;
            ServiceFactory serviceFactory = ServiceFactory.getInstance();

            try {
                riderService = (IRiderService) serviceFactory.getService(IRiderService.NAME);
                assertTrue(riderService instanceof RiderServiceImpl);
                System.out.println(riderService);
            } catch (ServiceLoadException e) {
                System.out.println(e);
            }

        }


    }


