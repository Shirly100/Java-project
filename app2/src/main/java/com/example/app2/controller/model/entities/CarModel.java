package com.example.app2.controller.model.entities;

/**
 * Created by Shirly on 11/12/2017.
 */
// information from http://www.cars-data.com/en/maserati-levante-s-specs/73805

public class CarModel
{
    private String modelCode;
    private String company;
    private String modelName;
    private String EngineCapacity;
    private Enums.Gear gear;
    private int SeatingCapacity;
    private int DoorsNumber;
    private String emptyMass;
    private  String fuel;
    private  String engine_type;
    private Enums.Answer turbo;
    private  Enums.Answer Lighted_makeup_mirror;
    private Enums.Answer Digital_radio;
    private Enums.Answer Panorama;
    private Enums.Answer Driver_airbag;
    private Enums.Answer Emergency_brake_assist;
    private String Total_max_power;

    public Enums.Answer getTurbo() {
        return turbo;
    }

    public void setTurbo(Enums.Answer turbo) {
        this.turbo = turbo;
    }

    public Enums.Answer getLighted_makeup_mirror() {
        return Lighted_makeup_mirror;
    }

    public void setLighted_makeup_mirror(Enums.Answer lighted_makeup_mirror) {
        Lighted_makeup_mirror = lighted_makeup_mirror;
    }

    public Enums.Answer getDigital_radio() {
        return Digital_radio;
    }

    public void setDigital_radio(Enums.Answer digital_radio) {
        Digital_radio = digital_radio;
    }

    public Enums.Answer getPanorama() {
        return Panorama;
    }

    public void setPanorama(Enums.Answer panorama) {
        Panorama = panorama;
    }

    public Enums.Answer getDriver_airbag() {
        return Driver_airbag;
    }

    public void setDriver_airbag(Enums.Answer driver_airbag) {
        Driver_airbag = driver_airbag;
    }

    public Enums.Answer getEmergency_brake_assist() {
        return Emergency_brake_assist;
    }

    public void setEmergency_brake_assist(Enums.Answer emergency_brake_assist) {
        Emergency_brake_assist = emergency_brake_assist;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getEngineCapacity() {
        return EngineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        EngineCapacity = engineCapacity;
    }

    public Enums.Gear getGear() {
        return gear;
    }

    public void setGear(Enums.Gear gear) {
        this.gear = gear;
    }

    public int getSeatingCapacity() {
        return SeatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        SeatingCapacity = seatingCapacity;
    }

    public int getDoorsNumber() {
        return DoorsNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        DoorsNumber = doorsNumber;
    }

    public String getEmptyMass() {
        return emptyMass;
    }

    public void setEmptyMass(String emptyMass) {
        this.emptyMass = emptyMass;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getEngine_type() {
        return engine_type;
    }

    public void setEngine_type(String engine_type) {
        this.engine_type = engine_type;
    }


    public String getTotal_max_power() {
        return Total_max_power;
    }

    public void setTotal_max_power(String total_max_power) {
        Total_max_power = total_max_power;
    }
}
