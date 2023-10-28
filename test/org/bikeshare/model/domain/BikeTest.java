package org.bikeshare.model.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BikeTest {

    @Test
    public void dummyBikeTest() {
        Bike dummyBike = new Bike ();
        assertTrue ("Check for the no bike creation", dummyBike.getBikeSerialNum() == "No Bike");
        System.out.println("Dummy Bike Constructor Test: PASSED");
    }

    @Test
    public void addMilesTest() {
        Bike dummyBike = new Bike ();
        long preTripMiles = dummyBike.getTotalMillage();
        dummyBike.addTripMiles(30);
        long postTripMiles = dummyBike.getTotalMillage();
        assertEquals ((preTripMiles + 30), postTripMiles);
        System.out.println("Adding Bike Miles Test: PASSED");
    }
}