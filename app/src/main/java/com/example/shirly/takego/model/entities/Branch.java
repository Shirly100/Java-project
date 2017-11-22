package com.example.shirly.takego.model.entities;

/**
 * Created by Shirly on 11/12/2017.
 */

public class Branch
{

    private  int parking_spacees;
    private  int branchNumber;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddressNumber(int number) {
        this.address.setNumber( number);
    }
    public void setAddressCity(String city) {
        this.address.setCity(city);
    }
    public void setAddressStreet(String street) {
        this.address.setStreet(street);
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
