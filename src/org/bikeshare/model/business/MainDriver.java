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
import org.bikeshare.model.services.waypointservice.IWaypointService;
import org.bikeshare.model.services.waypointservice.WaypointServiceImpl;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args){

        BikeShareManager bikeShareManager = BikeShareManager.getInstance();

        WaypointServiceImpl waypointService = new WaypointServiceImpl();

        System.out.println(Arrays.toString(waypointService.showWaypoints()));

        String[] waypointList = bikeShareManager.performAction("GetWaypoints");

        System.out.println(Arrays.toString(waypointList));


        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IService waypointService2;

        try {
            waypointService2 = (IWaypointService)serviceFactory.getService(IWaypointService.NAME);
            System.out.println(waypointService2.toString());
        }
        catch(ServiceLoadException e){
            System.out.println(e);
        }

    }
}
