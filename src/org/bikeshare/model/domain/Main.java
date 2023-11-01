package org.bikeshare.model.domain;

/**
 * This is just a class for a main method used for testing the classes for now. It will get deleted.
 */
public class Main {
    public static void main(String[] args) {

        Bike canyonGrail = new Bike("abc", 2000, 100, 100, 100, false, false, BikeType.CRUISER, BikeSize.SMALL);
        Rider alex = new Rider("Alex", "Fargo", "test@tester.com", "pass567");
        Waypoint main = new Waypoint("main street", 12.45, 67.113,"COS", 7);

        System.out.println(canyonGrail);
        System.out.println(alex);
        System.out.println(main);
        System.out.println(alex.getCustomerBike());
        System.out.println(canyonGrail.getBikeSize());
        System.out.println(canyonGrail.getBikeType());

    }
}