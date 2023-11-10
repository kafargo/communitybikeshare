package org.bikeshare.model.services.bikeservice;

import org.bikeshare.model.domain.Bike;
import org.bikeshare.model.services.IService;
import org.bikeshare.model.services.exceptions.BikeUsageException;

public interface IBikeService extends IService {

    String NAME = "IBikeService";
    boolean checkIfInUse(Bike bike);
    boolean checkIfNeedsMaintenance(Bike bike);
    void autoUpdateMaintenanceFlag(Bike bike);
    void setUsage(Bike bike, boolean newState) throws BikeUsageException;
}