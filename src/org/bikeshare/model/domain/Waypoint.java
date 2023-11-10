package org.bikeshare.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


/**
 * The Waypoint class is a representation of a physical location where bikes can be stored for use.
 * Waypoints are used in place of an address here because these locations may not be close to an
 * actual address.
 * @author kevinfargo
 */
public class Waypoint implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private double latitudeDecimalDegree;
    private double longitudeDecimalDegree;
    private String city;
    private int totalAvailableCapacity;
    Collection<Bike> listOfBikes = new ArrayList<>();


    public Waypoint(String name, double latitudeDecimalDegree, double longitudeDecimalDegree, String city, int totalAvailableCapacity) {
        this.name = name;
        this.latitudeDecimalDegree = latitudeDecimalDegree;
        this.longitudeDecimalDegree = longitudeDecimalDegree;
        this.city = city;
        this.totalAvailableCapacity = totalAvailableCapacity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTotalAvailableCapacity() {
        return totalAvailableCapacity;
    }

    public void setTotalAvailableCapacity(int totalAvailableCapacity) {
        this.totalAvailableCapacity = totalAvailableCapacity;
    }

    public int showOpenCapacity(){
        int capacity;
        capacity = this.totalAvailableCapacity - listOfBikes.size();
        return capacity;
    }

    /**
     * Adds a bike to the waypoint as long as there is capacity in the waypoint for it to be added.
     * Will return a boolean indicating if it was able to actually able to be added or not.
     * @param  bike  a bike to be added to the waypoint
     * @return      true if it was able to add the bike, and false if the bike could not be added
     */
    public boolean addBike(Bike bike){
        if (bike.getBikeSerialNum() != "No Bike" && this.showOpenCapacity() > 0) {
            listOfBikes.add(bike);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Removes a bike to the waypoint if the bike can be found in the collection.
     * Will return a boolean indicating if it was able to actually able to be removed or not.
     * @param  bike  a bike to be added to the waypoint
     * @return      true if it was able to remove the bike, and false if the bike could not be found
     */
    public boolean removeBike(Bike bike){

        if (listOfBikes.contains(bike)) {
            listOfBikes.remove(bike);
            return true;
        }
        else{
            return false;
        }

    }


    /**
     * This method is strictly for testing. It allows for a simple junit test to validate an instance of the class.
     * @return      true if it was able to validate the class, and false otherwise
     */
    public boolean validate() {
        if (name.isEmpty())
            return false;
        if (latitudeDecimalDegree == 0)
            return false;
        if (longitudeDecimalDegree == 0)
            return false;
        if (city.isEmpty())
            return false;
        if (!(totalAvailableCapacity > 0))
            return false;
        else return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waypoint waypoint = (Waypoint) o;
        return Double.compare(waypoint.latitudeDecimalDegree, latitudeDecimalDegree) == 0 && Double.compare(waypoint.longitudeDecimalDegree, longitudeDecimalDegree) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitudeDecimalDegree, longitudeDecimalDegree);
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "name='" + name + '\'' +
                ", latitudeDecimalDegree=" + latitudeDecimalDegree +
                ", longitudeDecimalDegree=" + longitudeDecimalDegree +
                ", city='" + city + '\'' +
                ", totalAvailableCapacity=" + totalAvailableCapacity +
                ", listOfBikes=" + listOfBikes +
                '}';
    }
}
