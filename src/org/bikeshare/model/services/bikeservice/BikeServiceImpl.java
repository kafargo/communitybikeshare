package org.bikeshare.model.services.bikeservice;

import org.bikeshare.model.domain.Bike;
import org.bikeshare.model.services.exceptions.BikeUsageException;

public class BikeServiceImpl implements IBikeService{
    @Override
    public boolean checkIfInUse(Bike bike) {
        return bike.inUse();
    }

    @Override
    public boolean checkIfNeedsMaintenance(Bike bike) {
        return bike.isNeedsMaintenance();
    }

    @Override
    public void autoUpdateMaintenanceFlag(Bike bike) {
        if(bike.getFrontTyreMillage() > 1000 || bike.getRearTyreMillage() > 1000){
            bike.setNeedsMaintenance(true);
        }
        else if (bike.getChainMillage() > 2000){
            bike.setNeedsMaintenance(true);
        }
    }

    @Override
    public void setUsage(Bike bike, boolean newState) throws BikeUsageException {
        if(!bike.inUse() && newState){
            bike.checkOutBike();
        }
        else if (bike.inUse() && !newState){
            bike.checkInBike();
        }
        else if (bike.inUse() && newState){
            throw new BikeUsageException("Bike is already in use");
        }

    }
}
