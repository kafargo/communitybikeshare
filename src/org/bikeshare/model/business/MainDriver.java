package org.bikeshare.model.business;

import org.bikeshare.model.business.exception.ServiceLoadException;
import org.bikeshare.model.business.manager.BikeShareManager;
import org.bikeshare.model.domain.Rider;
import org.bikeshare.model.domain.TripComposite;
import org.bikeshare.model.services.IService;
import org.bikeshare.model.services.factory.ServiceFactory;
import org.bikeshare.model.services.loginservice.ILoginService;
import org.bikeshare.model.services.loginservice.LoginServiceImpl;
import org.bikeshare.model.services.riderservice.IRiderService;

public class MainDriver {

    public static void main(String[] args){

        BikeShareManager bikeShareManager = BikeShareManager.getInstance();

        Rider rider = new Rider("James", "Cameron", "james@test.org","password");

        LoginServiceImpl login = new LoginServiceImpl();

        System.out.println(login.authenticateRider(rider));

        TripComposite tripComposite = new TripComposite();
        tripComposite.setRider(rider);

        boolean isRegistered = bikeShareManager.performAction("RegisterRider", tripComposite);

        String message = isRegistered ? "FleetRentalManager::main - Successfully registered customer"
                    : "FleetRentalManager::main - Failed to registered customer";
        System.out.println(message);


        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IService riderService;

        try {
            riderService = (IRiderService)serviceFactory.getService(IRiderService.NAME);
            System.out.println(riderService.toString());
        }
        catch(ServiceLoadException e){
            System.out.println(e);
        }

    }
}
