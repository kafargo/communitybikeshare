package org.bikeshare.model.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Waypoint {

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

    public String addBike(Bike bike){
        if (bike.getBikeSerialNum() != "No Bike" && this.showOpenCapacity() > 0) {
            listOfBikes.add(bike);
            return bike.getBikeSerialNum() + " Added to Waypoint";
        }
        else{
            return "Cant add bike";
        }
    }

    public String removeBike(Bike bike){

        if (listOfBikes.contains(bike)) {
            listOfBikes.remove(bike);
            return bike.getBikeSerialNum() + " Removed from Waypoint";
        }
        else{
            return "Cant find bike";
        }

    }

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
