package org.bikeshare.model.services.riderservice;

import org.bikeshare.model.domain.*;
import org.bikeshare.model.services.IService;
import org.bikeshare.model.services.exceptions.RiderCheckinException;
import org.bikeshare.model.services.exceptions.RiderCheckoutException;

public interface IRiderService extends IService {

    String NAME = "IRiderService";
    boolean checkIfRiderHasBike(Rider rider);
    boolean checkoutBike(Rider rider, Bike bike) throws RiderCheckoutException;
    boolean checkoutBike(TripComposite tripComposite) throws RiderCheckoutException;
    boolean returnRidersBike(Rider rider) throws RiderCheckinException;;
    boolean updateRiderName(String newFirstName, String newLastName, Rider rider);
    boolean registerNewRider(TripComposite tripComposite);
}
