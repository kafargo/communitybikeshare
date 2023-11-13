package org.bikeshare.model.services.factory;

import org.bikeshare.model.business.exception.ServiceLoadException;
import org.bikeshare.model.domain.Bike;
import org.bikeshare.model.domain.Rider;
import org.bikeshare.model.services.loginservice.ILoginService;
import org.bikeshare.model.services.loginservice.LoginServiceImpl;
import org.bikeshare.model.services.riderservice.IRiderService;
import org.bikeshare.model.services.riderservice.RiderServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class ServiceFactoryTest {

        ServiceFactory serviceFactory;
        Rider rider;

        @Before
        public void setUp() {
            serviceFactory = ServiceFactory.getInstance();
            rider = new Rider("guy","withbike","test@testme.com",true,new Bike());
        }

        /**
         * Test Factory to return the two services below and assert them by
         * checking if the service implementations are implementations of the Interface
         */

        @Test
        public void testGetRiderHasBikeService() {
            IRiderService riderHasBikeService = null;
            try {
                riderHasBikeService = (IRiderService) serviceFactory.getService(IRiderService.NAME);
            } catch (ServiceLoadException e) {
                throw new RuntimeException(e);
            }
            assertTrue(riderHasBikeService instanceof RiderServiceImpl);
        }

        @Test
        public void testGetLoginService() {
            ILoginService loginService;
            try {
                loginService = (ILoginService)serviceFactory.getService(ILoginService.NAME);
                assertTrue(loginService instanceof LoginServiceImpl);
                System.out.println("testGetLoginService PASSED");
            } catch (ServiceLoadException e) {
                e.printStackTrace();
                fail("ServiceLoadException");
            }
        }

    }


