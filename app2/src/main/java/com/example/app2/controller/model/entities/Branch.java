package com.example.app2.controller.model.entities;

/**
 * Created by Shirly on 11/12/2017.
 */

public class Branch
{

    private  int parking_spacees;
    private  int branchNumber;
    private String city;
    private String street;
    private int number;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
