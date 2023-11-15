package org.bikeshare.model.business;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.bikeshare.model.business.manager.BikeShareManagerTest;

public class AllBusinessTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test for org.bikeshare.model.business");

        suite.addTestSuite(BikeShareManagerTest.class);

        return suite;
    }

}
