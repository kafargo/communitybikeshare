package org.bikeshare.model.domain;


public class Main {
    public static void main(String[] args) {

        Bike canyonGrail = new Bike("abc", 100, 100, 100, 100, false, false, "gravel", "small");
        Customer alex = new Customer("Alex", "Fargo", "test@tester.com");
        Waypoint main = new Waypoint("main street", 12.45, 67.113,"COS", 7);

        System.out.println(canyonGrail);
        System.out.println(alex);
        System.out.println(main);
    }
}