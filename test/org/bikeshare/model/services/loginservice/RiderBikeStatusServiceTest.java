package org.bikeshare.model.services.loginservice;

import org.bikeshare.model.domain.Bike;
import org.bikeshare.model.domain.Rider;
import org.bikeshare.model.services.riderbikestatusservice.RiderBikeStatusServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RiderBikeStatusServiceTest {

        Rider rider;
        RiderBikeStatusServiceImpl bikeStatusService;

        @Before
        public void setUp() throws Exception {
            rider = new Rider("guy","withbike","test@test.com",true,new Bike());
            bikeStatusService = new RiderBikeStatusServiceImpl();
        }

        /**
         * The service is not really going to work right now because it checks the database not the actuall class values
         */
        @Test
        public void testRiderBikeStatusServiceResult() {
            assertFalse(bikeStatusService.checkIfRiderHasBike(rider));
        }

    }

