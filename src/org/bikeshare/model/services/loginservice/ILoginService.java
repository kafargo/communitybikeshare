package org.bikeshare.model.services.loginservice;


import org.bikeshare.model.domain.Rider;

public interface ILoginService {

    boolean authenticateRider(Rider rider);

}
