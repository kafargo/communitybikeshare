package org.bikeshare.model.services.factory;

import org.bikeshare.model.services.loginservice.ILoginService;
import org.bikeshare.model.services.loginservice.LoginServiceImpl;

public class ServiceFactory {

    /**
     * Simplistic implementation of a Service Factory.
     */

        public ILoginService getLoginService()
        {
            return new LoginServiceImpl();
        }

}
