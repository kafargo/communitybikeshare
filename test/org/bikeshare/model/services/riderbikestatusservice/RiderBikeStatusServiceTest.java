package org.bikeshare.model.services.riderbikestatusservice;

import org.bikeshare.model.domain.Bike;
import org.bikeshare.model.domain.BikeSize;
import org.bikeshare.model.domain.BikeType;
import org.bikeshare.model.domain.Rider;
import org.bikeshare.model.services.exceptions.RiderCheckinException;
import org.bikeshare.model.services.exceptions.RiderCheckoutException;
import org.bikeshare.model.services.riderbikestatusservice.RiderServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RiderBikeStatusServiceTest {

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
        public void setUp() throws Exception {

            testBike = new Bike("abc", 2000, 100, 100, 100, false, false, BikeType.CRUISER, BikeSize.SMALL);
            riderWithBike = new Rider("Yes", "Bike", "test@tester.com", true, testBike);
            riderWithoutBike = new Rider("No", "Bike", "test@testme.com", "test");
            riderService = new RiderServiceImpl();
        }

        /**
         * The service is not really going to work right now because it checks the database not the actuall class values.
         * I need to research how to mock a DB connection for this first test
         */
        @Test
        public void testRiderServiceBikeStatusResult() {
            assertFalse(riderService.checkIfRiderHasBike(riderWithBike));
        }

        /**
         * The below test will actually work because there is no DB to work against
         */
        @Test
        public void testRiderServiceAddBikeToRider() {
            try{
                riderService.addBikeToRider(riderWithBike, testBike);
            }catch (RiderCheckoutException e){
                assertEquals(e.getMessage(), "Rider already has a bike");
            }
            //assertEquals(false,riderService.addBikeToRider(riderWithBike, testBike));
        }

        @Test
        public void testRiderServiceReturnRidersBike() throws RiderCheckinException {
            try{
                riderService.returnRidersBike(riderWithoutBike);
            }catch (RiderCheckinException e){
                assertEquals(e.getMessage(), "This rider has no bike to checkin");
            }
            assertEquals(true,riderService.returnRidersBike(riderWithBike));
        }

        @Test
        public void testRiderServiceUpdateRiderName() {
            riderService.updateRiderName("real", "name", riderWithoutBike);
            assertEquals("real",riderWithoutBike.getFirstName());
            assertEquals("name",riderWithoutBike.getLastName());
        }


    }

