package org.bikeshare.model.services.factory;

import org.bikeshare.model.domain.Bike;
import org.bikeshare.model.services.IService;
import org.bikeshare.model.business.exception.ServiceLoadException;
import org.bikeshare.model.services.riderbikestatusservice.IRiderService;
import org.bikeshare.model.services.riderbikestatusservice.RiderServiceImpl;
import org.bikeshare.model.services.loginservice.*;
import org.bikeshare.model.domain.Rider;
import org.junit.Before;
import org.junit.Test;
import static org.bikeshare.model.services.factory.ServiceFactory.getInstance;

import static org.junit.Assert.assertTrue;



    public class ServiceFactoryTest {

        ServiceFactory serviceFactory;
        Rider rider;

        @Before
        public void setUp() throws Exception {
            serviceFactory = getInstance();
            rider = new Rider("guy","withbike","test@testme.com",true,new Bike());
        }

        /**
         * Test Factory to return the two services below and assert them by
         * checking if the service implementations are implementations of the Interface
         */
        @Test
        public void testGetLoginService() throws ServiceLoadException {
            ILoginService loginService = (ILoginService)serviceFactory.getService("ILoginService");
            assertTrue(loginService instanceof LoginServiceImpl);
        }

        @Test
        public void testGetRiderHasBikeService() throws ServiceLoadException {
            IRiderService riderHasBikeService = (IRiderService) serviceFactory.getService("IRiderService");
            assertTrue(riderHasBikeService instanceof RiderServiceImpl);
        }

    }


