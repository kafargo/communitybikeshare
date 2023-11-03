package org.bikeshare.model.services.factory;

import org.bikeshare.model.domain.Bike;
import org.bikeshare.model.services.riderbikestatusservice.IRiderService;
import org.bikeshare.model.services.riderbikestatusservice.RiderServiceImpl;
import org.bikeshare.model.services.loginservice.*;
import org.bikeshare.model.domain.Rider;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;



    public class ServiceFactoryTest {

        ServiceFactory serviceFactory;
        Rider rider;

        @Before
        public void setUp() throws Exception {
            serviceFactory = new ServiceFactory();
            rider = new Rider("guy","withbike","test@testme.com",true,new Bike());
        }

        /**
         * Test Factory to return the two services below and assert them by
         * checking if the service implementations are implementations of the Interface
         */
        @Test
        public void testGetLoginService() {
            ILoginService loginService = (ILoginService)serviceFactory.getLoginService();
            assertTrue(loginService instanceof LoginServiceImpl);
        }

        @Test
        public void testGetRiderHasBikeService() {
            IRiderService riderHasBikeService = (IRiderService) serviceFactory.getRiderService();
            assertTrue(riderHasBikeService instanceof RiderServiceImpl);
        }

        @Test
        public void testRiderHasBikeServiceResult() {
            IRiderService riderHasBikeService = (IRiderService) serviceFactory.getRiderService();
            assertTrue(riderHasBikeService instanceof RiderServiceImpl);
        }
    }


