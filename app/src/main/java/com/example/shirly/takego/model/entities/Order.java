package com.example.shirly.takego.model.entities;
import java.util.Date;
/**
 * Created by Shirly on 11/12/2017.
 */

public class Order
{
    private long clientNumber;
    private Enums.Order order ;
    private long carNumber;
    private Date rental_srart_date;
    private Date rental_end_date;
    private  float mileage_start_value;
    private  float mileage_end_value;
    private  boolean fuel_filling;
    private float quantity_of_fuel;
    private  float payment;
    private long orderNumber;

    public long getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(long clientNumber) {
        this.clientNumber = clientNumber;
    }

    public Enums.Order getOrder() {
        return order;
    }

    public void setOrder(Enums.Order order) {
        this.order = order;
    }

    public long getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(long carNumber) {
        this.carNumber = carNumber;
    }

    public Date getRental_srart_date() {
        return rental_srart_date;
    }

    public void setRental_srart_date(Date rental_srart_date) {
        this.rental_srart_date = rental_srart_date;
    }

    public Date getRental_end_date() {
        return rental_end_date;
    }

    public void setRental_end_date(Date rental_end_date) {
        this.rental_end_date = rental_end_date;
    }

    public float getMileage_start_value() {
        return mileage_start_value;
    }

    public void setMileage_start_value(float mileage_start_value) {
        this.mileage_start_value = mileage_start_value;
    }

    public float getMileage_end_value() {
        return mileage_end_value;
    }

    public void setMileage_end_value(float mileage_end_value) {
        this.mileage_end_value = mileage_end_value;
    }

    public boolean isFuel_filling() {
        return fuel_filling;
    }

    public void setFuel_filling(boolean fuel_filling) {
        this.fuel_filling = fuel_filling;
    }

    public float getQuantity_of_fuel() {
        return quantity_of_fuel;
    }

    public void setQuantity_of_fuel(float quantity_of_fuel) {
        this.quantity_of_fuel = quantity_of_fuel;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
