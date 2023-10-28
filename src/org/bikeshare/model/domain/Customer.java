package org.bikeshare.model.domain;

import java.util.Objects;

public class Customer {

    private String firstName;
    private String lastName;
    private String emailAddress;
    //indicates if the customer has a bike in their possession
    private boolean hasBike;
    private Bike bike;

    //Default constructor that includes all parameters of the object
    public Customer(String firstName, String lastName, String emailAddress, boolean hasBike, Bike bike) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.hasBike = hasBike;
        this.bike = bike;
    }

    //Overloaded constructor that would be used for creating a first time customer who could not have a bike by default
    public Customer(String firstName, String lastName, String emailAddress) {
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

    public String takePossessionOfBike(Bike bike) {
        if (!hasBike && bike.getBikeSerialNum() != "No Bike") {
            if(!bike.inUse()) {
                this.bike = bike;
                this.hasBike = true;
                bike.checkOutBike();
                return "You checked out " + bike;
            }
            else{
                return "bike already in use";
            }

        }
        else return "You cant check out a bike";
    }

    public String returnBike(Bike bike) {
        if (hasBike) {
            this.bike = null;
            this.hasBike = false;
            bike.checkInBike();
            return "Bike Returned";
        }
        else{
            return "No Bike to Return";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return emailAddress.equals(customer.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }

    //Validate class
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
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", hasBike=" + hasBike +
                ", bike=" + bike +
                '}';
    }
}
