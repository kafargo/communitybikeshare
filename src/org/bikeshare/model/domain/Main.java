package org.bikeshare.model.domain;


import org.bikeshare.model.services.riderbikestatusservice.IRiderService;
import org.bikeshare.model.services.riderbikestatusservice.RiderServiceImpl;

/**
 * This is just a class for a main method used for testing the classes for now. It will get deleted.
 */
public class Main {
    public static void main(String[] args) {

        Bike canyonGrail = new Bike("abc", 2000, 100, 100, 100, false, false, BikeType.CRUISER, BikeSize.SMALL);
        Rider alex = new Rider("Alex", "Fargo", "test@tester.com", true, canyonGrail);
        Waypoint main = new Waypoint("main street", 12.45, 67.113,"COS", 7);

        IRiderService riderservice = new RiderServiceImpl();

        System.out.println(alex);
        System.out.println(riderservice.updateRiderName("Jordan", "Peaks", alex));
        System.out.println(alex);

    }
}