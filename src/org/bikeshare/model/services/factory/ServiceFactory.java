package org.bikeshare.model.services.factory;

import org.bikeshare.model.services.loginservice.ILoginService;
import org.bikeshare.model.services.loginservice.LoginServiceImpl;
import org.bikeshare.model.services.riderbikestatusservice.IRiderService;
import org.bikeshare.model.services.riderbikestatusservice.RiderServiceImpl;

public class ServiceFactory {

    /**
     * Simplistic implementation of a Service Factory.
     */

        public ILoginService getLoginService()
        {
            return new LoginServiceImpl();
        }
        public IRiderService getRiderService() {return new RiderServiceImpl();}

}
