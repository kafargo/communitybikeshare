package org.bikeshare.model.domain;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllDomainTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test for org.bikeshare.model.domain");

        suite.addTestSuite(BikeTest.class);
        suite.addTestSuite(WaypointTest.class);

        return suite;
    }

}
