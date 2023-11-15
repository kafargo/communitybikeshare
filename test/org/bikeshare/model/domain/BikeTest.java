package org.bikeshare.model.domain;

import junit.framework.TestCase;

public class BikeTest extends TestCase {

    public void testNewBikeTest() {
        Bike newBike = new Bike ("XYZ", BikeType.CRUISER, BikeSize.MEDIUM );
        assertEquals (newBike.getTotalMillage(), 0);
        System.out.println("New Bike Constructor Test: PASSED");
    }

    public void testAddMilesTest() {
        Bike dummyBike = new Bike ("XYZ", BikeType.CRUISER, BikeSize.MEDIUM );
        long preTripMiles = dummyBike.getTotalMillage();
        dummyBike.addTripMiles(30);
        long postTripMiles = dummyBike.getTotalMillage();
        assertEquals ((preTripMiles + 30), postTripMiles);
        System.out.println("Adding Bike Miles Test: PASSED");
    }
}