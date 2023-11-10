package org.bikeshare.model.business;

import org.bikeshare.model.business.exception.ServiceLoadException;
import org.bikeshare.model.domain.*;
import org.bikeshare.model.services.factory.ServiceFactory;
import org.bikeshare.model.services.riderbikestatusservice.IRiderService;
import org.bikeshare.model.services.riderbikestatusservice.RiderServiceImpl;


import static org.bikeshare.model.services.factory.ServiceFactory.getInstance;

public class MainDriver {

    public static void main(String[] args) throws ServiceLoadException {

        Bike canyonGrail = new Bike("abc", 2000, 100, 100, 100, false, false, BikeType.CRUISER, BikeSize.SMALL);
        Rider alex = new Rider("Alex", "Fargo", "test@tester.com", true, canyonGrail);
        Waypoint main = new Waypoint("main street", 12.45, 67.113,"COS", 7);
        ServiceFactory serviceFactory;

        IRiderService riderservice = new RiderServiceImpl();

        System.out.println(alex);
        System.out.println(riderservice.updateRiderName("Jordan", "Peaks", alex));
        System.out.println(alex);

        serviceFactory = getInstance();
        System.out.println(serviceFactory.getService("IRiderService").toString());

    }
}
