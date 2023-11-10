package org.bikeshare.model.services.loginservice;


import org.bikeshare.model.domain.Rider;
import org.bikeshare.model.services.IService;
import org.bikeshare.model.services.exceptions.RiderCheckinException;

public interface ILoginService extends IService {

    public final String NAME = "ILoginService";
    boolean authenticateRider(Rider rider);
}
