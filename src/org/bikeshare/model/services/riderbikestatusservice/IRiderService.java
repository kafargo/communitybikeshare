package org.bikeshare.model.services.riderbikestatusservice;

import org.bikeshare.model.domain.*;

public interface IRiderService {
    boolean checkIfRiderHasBike(Rider rider);
    boolean addBikeToRider(Rider rider, Bike bike);
    boolean returnRidersBike(Rider rider);
    boolean updateRiderName(String newFirstName, String newLastName, Rider rider);
}
