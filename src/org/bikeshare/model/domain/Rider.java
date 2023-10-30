package org.bikeshare.model.domain;

import java.util.Objects;

/**
 * The Rider class creates a person who is intrested in checking out a bike.
 * This class is light weight because these people do not pay for any service,
 * rather is a lot like a library for bikes. accortingly, payment related information
 * is not necessary.
 * @author kevinfargo
 */
public class Rider {

    private String firstName;
    private String lastName;
    private String emailAddress;

    /**
     * hasBike is a boolean that indicates if a customer has a bike or not.
     * Per requirements, customers cannot have more than one bike at a time.
     */
    private boolean hasBike;
    private Bike bike;

    /**
     * Default constructor including all parameters of the class
     */
    public Rider(String firstName, String lastName, String emailAddress, boolean hasBike, Bike bike) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.hasBike = hasBike;
        this.bike = bike;
    }

    /**
     * Constructor for first time customers which will not have a bike to start out.
     */
    public Rider(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.hasBike = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean getHasBike() {
        return hasBike;
    }

    public Bike getCustomerBike() {
        return bike;
    }

    /**
     * Adds a bike to the rider as long as the rider does not already have a bike.
     * Will return a boolean indicating if it was able to actually able to be added or not.
     * @param  bike  a bike to be checked out by a rider
     * @return      true if it was able to add the bike, and false if the bike could not be added
     */
    public boolean takePossessionOfBike(Bike bike) {
        if (!hasBike && bike.getBikeSerialNum() != "No Bike") {
            if(!bike.inUse()) {
                this.bike = bike;
                this.hasBike = true;
                bike.checkOutBike();
                return true;
            }
            else{
                return false;
            }

        }
        else return false;
    }

    /**
     * Method to remove a bike from a rider and also reset their hasBike status.
     * @param  bike  a bike to be returned by the rider
     * @return      true if bike was successfully returned, and false if there was no bike to return
     */
    public boolean returnBike(Bike bike) {
        if (hasBike) {
            this.bike = null;
            this.hasBike = false;
            bike.checkInBike();
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rider rider = (Rider) o;
        return emailAddress.equals(rider.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }

    /**
     * This method is strictly for testing. It allows for a simple junit test to validate an instance of the class.
     * @return      true if it was able to validate the class, and false otherwise
     */
    public boolean validate() {
        if (lastName == null)
            return false;
        if (firstName == null)
            return false;
        if (emailAddress == null)
            return false;
        if (bike == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", hasBike=" + hasBike +
                ", bike=" + bike +
                '}';
    }
}
