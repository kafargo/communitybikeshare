package org.bikeshare.model.domain;

/**
 * This is just a class for a main method used for testing the classes for now. It will get deleted.
 */
public class Main {
    public static void main(String[] args) {

        Bike canyonGrail = new Bike("abc", 100, 100, 100, 100, false, false, "gravel", "small");
        Rider alex = new Rider("Alex", "Fargo", "test@tester.com");
        Waypoint main = new Waypoint("main street", 12.45, 67.113,"COS", 7);

        System.out.println(canyonGrail);
        System.out.println(alex);
        System.out.println(main);
        System.out.println(alex.getCustomerBike());
    }
}