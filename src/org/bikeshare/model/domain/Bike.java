package org.bikeshare.model.domain;

import java.util.Objects;

public class Bike {

    private String bikeSerialNum;
    private long totalMillage;
    private int frontTyreMillage;
    private int rearTyreMillage;
    private int chainMillage;
    private boolean inUse;
    private boolean needsMaintenance;
    private String bikeType;
    private String bikeSize;


    //default constructor
    public Bike(String bikeSerialNum, long totalMillage, int frontTyreMillage, int rearTyreMillage, int chainMillage, boolean inUse, boolean needsMaintenance, String bikeType, String bikeSize) {
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

    //constructor for creating a 'defualt' bike
    public Bike() {
        this.bikeSerialNum = "No Bike";
        this.totalMillage = 0;
        this.frontTyreMillage = 0;
        this.rearTyreMillage = 0;
        this.chainMillage = 0;
        this.inUse = false;
        this.needsMaintenance = false;
        this.bikeType = "N/A";
        this.bikeSize = "N/A";
    }

    //getters and setters
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

    public String getBikeType() {
        return bikeType;
    }

    public String getBikeSize() {
        return bikeSize;
    }


    //other special methods

    public String addTripMiles(int miles){
        this.totalMillage += miles;
        this.chainMillage  += miles;
        this.frontTyreMillage += miles;
        this.rearTyreMillage += miles;
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
