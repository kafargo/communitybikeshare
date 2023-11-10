package org.bikeshare.model.services.riderbikestatusservice;

import org.bikeshare.model.domain.Bike;
import org.bikeshare.model.domain.Rider;
import org.bikeshare.model.services.exceptions.RiderCheckinException;
import org.bikeshare.model.services.exceptions.RiderCheckoutException;


public class RiderServiceImpl implements IRiderService {

    /**
     * Checks to see if the Rider has a Bike.
     *  @param rider contains rider details
     */
    @Override
    public boolean checkIfRiderHasBike(Rider rider){
        return rider.getHasBike();
    }

    /**
     * The below method adds a bike to the rider
     * @param rider
     * @param bike
     * @return boolean which represents if it succeeded or not
     */
    @Override
    public boolean addBikeToRider(Rider rider, Bike bike) throws RiderCheckoutException {
        if(!rider.getHasBike()){
            rider.takePossessionOfBike(bike);
            return true;
        }
        else throw new RiderCheckoutException("Rider already has a bike");
    }

    /**
     * The below method is for the rider to drop off the bike
     * @param rider
     * @return boolean which represents if it succeeded or not
     */
    @Override
    public boolean returnRidersBike(Rider rider) throws RiderCheckinException {
        if(rider.getHasBike()){
            rider.returnBike(rider.getBike());
            return true;
        }
        else{
            throw new RiderCheckinException("This rider has no bike to checkin");
        }
    }

    /**
     * This is a simple method to update the Riders name
     * @param newFirstName
     * @param newLastName
     * @param rider
     * @return boolean which represents if it succeeded or not
     */
    @Override
    public boolean updateRiderName(String newFirstName, String newLastName, Rider rider) {
        rider.setFirstName(newFirstName);
        rider.setLastName(newLastName);
        return true;
    }

}
