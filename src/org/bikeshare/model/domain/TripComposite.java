package org.bikeshare.model.domain;

import java.io.Serializable;

public class TripComposite implements Serializable {

    private static final long serialVersionUID = 1L;
    private Bike bike;
    private Rider rider;
    private Waypoint waypoint;

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Waypoint getWaypoint() {
        return waypoint;
    }

    public void setWaypoint(Waypoint waypoint) {
        this.waypoint = waypoint;
    }

    @Override
    public String toString()
    {
        StringBuffer strBfr = new StringBuffer();
        strBfr.append("Bike :");
        strBfr.append(bike);
        strBfr.append("\nWaypoint :");
        strBfr.append(waypoint);
        strBfr.append("\nRider :");
        strBfr.append(rider);

        return strBfr.toString();
    }

}
