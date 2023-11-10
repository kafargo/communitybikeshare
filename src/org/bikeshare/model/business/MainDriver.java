package org.bikeshare.model.business;

import org.bikeshare.model.domain.*;
import org.bikeshare.model.services.riderbikestatusservice.IRiderService;
import org.bikeshare.model.services.riderbikestatusservice.RiderServiceImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainDriver {

    public static void main(String[] args) {

//        Bike canyonGrail = new Bike("abc", 2000, 100, 100, 100, false, false, BikeType.CRUISER, BikeSize.SMALL);
//        Rider alex = new Rider("Alex", "Fargo", "test@tester.com", true, canyonGrail);
//        Waypoint main = new Waypoint("main street", 12.45, 67.113,"COS", 7);
//
//        IRiderService riderservice = new RiderServiceImpl();
//
//        System.out.println(alex);
//        System.out.println(riderservice.updateRiderName("Jordan", "Peaks", alex));
//        System.out.println(alex);

        try (InputStream input = new FileInputStream("config/application.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("IRiderService"));
            System.out.println(prop.getProperty("IBikeService"));
            System.out.println(prop.getProperty("ILoginService"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
