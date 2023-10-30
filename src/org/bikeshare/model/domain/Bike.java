package org.bikeshare.model.domain;

import java.util.Objects;

/**
 * The Bike class creates an instance of a bike. Some key attributes here are the millage
 * of the chain and tyres because these components need to be replaced often so the bike can
 * remain in operation.
 * @author kevinfargo
 */
public class Bike {

    private String bikeSerialNum;
    private long totalMillage;
    private int frontTyreMillage;
    private int rearTyreMillage;
    private int chainMillage;
    /**
     * Indicates that the bike is in use.
     */
    private boolean inUse;
    /**
     * Indicates that the bike is in need of maintenance.
     */
    private boolean needsMaintenance;
    /**
     * Bike types and sizes cannot ever be changed, and are enums
     */
    private final BikeType bikeType;
    private final BikeSize bikeSize;


    /**
     * Default constructor
     */
    public Bike(String bikeSerialNum, long totalMillage, int frontTyreMillage, int rearTyreMillage, int chainMillage, boolean inUse, boolean needsMaintenance, BikeType bikeType, BikeSize bikeSize) {
        this.bikeSerialNum = bikeSerialNum;
        this.totalMillage = totalMillage;
        this.frontTyreMillage = frontTyreMillage;
        this.rearTyreMillage = rearTyreMillage;
        this.chainMillage = chainMillage;
        this.inUse = inUse;
        this.needsMaintenance = needsMaintenance;
        this.bikeType = bikeType;
        this.bikeSize = bikeSize;
    }

    /**
     * Constructor to create a dummy instance of a bike
     */
    public Bike() {
        this.bikeSerialNum = "No Bike";
        this.totalMillage = 0;
        this.frontTyreMillage = 0;
        this.rearTyreMillage = 0;
        this.chainMillage = 0;
        this.inUse = false;
        this.needsMaintenance = false;
        this.bikeType = BikeType.ROAD;
        this.bikeSize = BikeSize.SMALL;
    }


    public String getBikeSerialNum() {
        return bikeSerialNum;
    }

    public void setBikeSerialNum(String bikeSerialNum) {
        this.bikeSerialNum = bikeSerialNum;
    }

    public long getTotalMillage() {
        return totalMillage;
    }

    public int getFrontTyreMillage() {
        return frontTyreMillage;
    }

    public int getRearTyreMillage() {
        return rearTyreMillage;
    }

    public int getChainMillage() {
        return chainMillage;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    public BikeSize getBikeSize() {
        return bikeSize;
    }

    /**
     * Method to add miles from a trip to a bike and update all the key components with the millage.
     * @param  miles  the miles that the rider put on the bike while it was checked out.
     * @return a string that shows the total millage plus the millage of the tyres and chain (which may be different)
     */
    public String addTripMiles(int miles){
        this.totalMillage += miles;
        this.chainMillage  += miles;
        this.frontTyreMillage += miles;
        this.rearTyreMillage += miles;
        if (this.chainMillage > 500){
            this.needsMaintenance = true;
        }
        else if (this.frontTyreMillage > 1000){
            this.needsMaintenance = true;
        }
        else if (this.rearTyreMillage > 1000){
            this.needsMaintenance = true;
        }
        return "Bike " + this.bikeSerialNum + " now has " + this.totalMillage + " total miles | " + this.chainMillage + " miles on the chain | " + this.frontTyreMillage + " miles on the front tyre | " + this.rearTyreMillage + " miles on the rear tyre";
    }

    public void replaceChain(){
        this.chainMillage = 0;
    }

    public void replaceFrontTyre(){
        this.frontTyreMillage = 0;
    }

    public void replaceRearTyre(){
        this.rearTyreMillage = 0;
    }

    public void checkOutBike(){
        this.inUse = true;
    }

    public void checkInBike(){
        this.inUse = false;
    }

    public boolean inUse(){
        return inUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return bikeSerialNum.equals(bike.bikeSerialNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bikeSerialNum);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeSerialNum='" + bikeSerialNum + '\'' +
                ", totalMillage=" + totalMillage +
                ", frontTyreMillage=" + frontTyreMillage +
                ", rearTyreMillage=" + rearTyreMillage +
                ", chainMillage=" + chainMillage +
                ", inUse=" + inUse +
                ", needsMaintenance=" + needsMaintenance +
                ", bikeType='" + bikeType + '\'' +
                ", bikeSize='" + bikeSize + '\'' +
                '}';
    }
}
