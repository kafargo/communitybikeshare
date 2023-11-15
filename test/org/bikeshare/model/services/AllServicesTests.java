package org.bikeshare.model.services;

import org.bikeshare.model.services.factory.ServiceFactoryTest;
import org.bikeshare.model.services.riderservice.RiderServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ServiceFactoryTest.class, RiderServiceTest.class})
public class AllServicesTests {

}
