package org.bikeshare.model.business;

import org.bikeshare.model.business.exception.ServiceLoadException;
import org.bikeshare.model.services.IService;
import org.bikeshare.model.services.factory.ServiceFactory;
import org.bikeshare.model.services.riderservice.IRiderService;

public class MainDriver {

    public static void main(String[] args){


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
