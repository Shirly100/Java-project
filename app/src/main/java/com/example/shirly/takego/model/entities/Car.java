package com.example.shirly.takego.model.entities;

/**
 * Created by Shirly on 11/12/2017.
 */

public class Car
{
    private int branchNumber;
    private String modelType;
    private float mileage;
    private long carNumber;
    private  Enums.Answer occupied;

    public Enums.Answer getOccupied() {
        return occupied;
    }

    public void setOccupied(Enums.Answer occupied) {
        this.occupied = occupied;
    }
    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public long getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(long carNumber) {
        this.carNumber = carNumber;
    }
}
