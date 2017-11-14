package com.example.shirly.takego.model.entities;

/**
 * Created by Shirly on 11/12/2017.
 */

public class Branch
{
    private Address address;
    private  int parking_spacees;
    private  int branchNumber;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getParking_spacees() {
        return parking_spacees;
    }

    public void setParking_spacees(int parking_spacees) {
        this.parking_spacees = parking_spacees;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }
}
