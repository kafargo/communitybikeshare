package org.bikeshare.model.services.riderbikestatusservice;

import org.bikeshare.model.domain.Rider;

public interface IRiderBikeStatusService {
    boolean checkIfRiderHasBike(Rider rider);
}
