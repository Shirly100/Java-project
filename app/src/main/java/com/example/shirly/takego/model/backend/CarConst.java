package com.example.shirly.takego.model.backend;

import android.content.ContentValues;

import com.example.shirly.takego.model.entities.*;

import java.sql.Date;

/**
 * Created by Shirly on 11/14/2017.
 */

public class CarConst
{
    public static class BranchConst
    {
        public static final String PARKING= "parking_spacees";
        public static final String BRANCH_NAME=" branchNumber";
        public static final String CITY="city";
        public static final String STREET="street";
        public static final String NUMBER="number";
    }

    public static class CarsConst
    {
        public static final String BRANCH_NUMBER="branchNumber" ;
        public static final String  MODEL_TYPE="modelType";
        public static final String MILEAGE= "mileage";
        public static final String CAR_NUMBER= "carNumber";
    }

    public static class CarModelConst
    {
        public static final String  MODEL_CODE="modelCode";
        public static final String COMPANY="company";
        public static final String MODEL_NAME="modelName";
        public static final String ENGINE_CAPACITY="EngineCapacity";
        public static final String GEAR="gear";
        public static final String SEATING_CAPICITY="SeatingCapacity";
        public static final String DOORS_NUMBER="DoorsNumber";
        public static final String EMPTY_MASS="emptyMass";
        public static final String FUEL="fuel";
        public static final String ENGINE_TYPE="engine_type";
        public static final String TURBO="turbo";
        public static final String LIGHTED_MAKEUP_MIRROR="Lighted_makeup_mirror";
        public static final String DIGITAL_RADIO="Digital_radio";
        public static final String PANORAMA="Panorama";
        public static final String DRIVER_AIRBAG="Driver_airbag";
        public static final String EMERGENCY_BRAKE_ASSIST="Emergency_brake_assist";
        public static final String TOTAL_MAX_POWER="Total_max_power";
    }

    public static class ClientConst
    {
        public static final String LAST_NAME="lastName";
        public static final String FIRST_NAME="firstName";
        public static final String ID="ID";
        public static final String  PHONE_NUMBER="phoneNumber";
        public static final String MAIL="mail";
        public static final String CARD_NUMBER="cardNumber";
    }


    public static class OrderConst
    {
        public static final String CLIENT_NUMBER="clientNumber";
        public static final String ORDER="order";
        public static final String CAR_NUMBER="carNumber";
        public static final String  RENTAL_START_DATE="rental_srart_date";
        public static final String RENTAL_END_DATE="rental_end_date";
        public static final String MILEAGE_START_VALUE="mileage_start_value";
        public static final String MILEAGE_END_VALUE="mileage_end_value";
        public static final String FUEL_FILLING="fuel_filling";
        public static final String QUANTITY_OF_FUEL="quantity_of_fuel";
        public static final String PAYMENT=" payment";
        public static final String ORDER_NUMBER="orderNumber";


    }

    public static ContentValues BranchToContentValues(Branch branch) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(BranchConst.CITY, branch.getCity());
        contentValues.put(BranchConst.STREET,branch.getStreet());
        contentValues.put(BranchConst.NUMBER, branch.getNumber());
        contentValues.put(BranchConst.PARKING, branch.getParking_spacees());
        contentValues.put(BranchConst.BRANCH_NAME, branch.getBranchNumber());

        return contentValues;
    }


    public static ContentValues CarToContentValues(Car car) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarsConst.BRANCH_NUMBER, car.getBranchNumber());
        contentValues.put(CarsConst.MODEL_TYPE,car.getModelType());
        contentValues.put(CarsConst.MILEAGE, car.getMileage());
        contentValues.put(CarsConst.CAR_NUMBER, car.getCarNumber());

        return contentValues;
    }


    public static ContentValues CarModelToContentValues(CarModel model) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarModelConst.MODEL_CODE, model.getModelCode());
        contentValues.put(CarModelConst.COMPANY,model.getCompany());
        contentValues.put(CarModelConst.MODEL_NAME, model.getModelName());
        contentValues.put(CarModelConst.ENGINE_CAPACITY, model.getEngineCapacity());
        contentValues.put(CarModelConst.GEAR, String.valueOf(model.getGear()));
        contentValues.put(CarModelConst.SEATING_CAPICITY, model.getSeatingCapacity());
        contentValues.put(CarModelConst.DOORS_NUMBER, model.getDoorsNumber());
        contentValues.put(CarModelConst.EMPTY_MASS, model.getEmptyMass());
        contentValues.put(CarModelConst.FUEL, model.getFuel());
        contentValues.put(CarModelConst.ENGINE_TYPE, model.getEngine_type());
        contentValues.put(CarModelConst.TURBO, String.valueOf(model.getTurbo()));
        contentValues.put(CarModelConst.LIGHTED_MAKEUP_MIRROR, String.valueOf(model.getLighted_makeup_mirror()));
        contentValues.put(CarModelConst.DIGITAL_RADIO, String.valueOf(model.getDigital_radio()));
        contentValues.put(CarModelConst.PANORAMA, String.valueOf(model.getPanorama()));
        contentValues.put(CarModelConst.DRIVER_AIRBAG, String.valueOf(model.getDriver_airbag()));
        contentValues.put(CarModelConst.EMERGENCY_BRAKE_ASSIST, String.valueOf(model.getEmergency_brake_assist()));
        contentValues.put(CarModelConst.TOTAL_MAX_POWER, model.getTotal_max_power());

        return contentValues;
    }



    public static ContentValues ClientToContentValues(Client client) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ClientConst.LAST_NAME, client.getLastName());
        contentValues.put(ClientConst.FIRST_NAME, client.getFirstName());
        contentValues.put(ClientConst.ID, client.getID());
        contentValues.put(ClientConst.PHONE_NUMBER, client.getPhoneNumber());
        contentValues.put(ClientConst. MAIL, client.getMail());
        contentValues.put(ClientConst.CARD_NUMBER, client.getCardNumber());


        return contentValues;
    }

    public static ContentValues OrderToContentValues(Order order) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(OrderConst.CLIENT_NUMBER, order.getClientNumber());
        contentValues.put(OrderConst.ORDER, String.valueOf(order.getOrder()));
        contentValues.put(OrderConst.CAR_NUMBER, order.getCarNumber());
        contentValues.put(OrderConst. RENTAL_START_DATE, String.valueOf(order.getRental_srart_date()));
        contentValues.put(OrderConst. RENTAL_END_DATE, String.valueOf(order.getRental_end_date()));
        contentValues.put(OrderConst.MILEAGE_START_VALUE, order.getMileage_start_value());
        contentValues.put(OrderConst.MILEAGE_END_VALUE, order.getMileage_end_value());
        contentValues.put(OrderConst.FUEL_FILLING, order.isFuel_filling());
        contentValues.put(OrderConst.QUANTITY_OF_FUEL, order.getQuantity_of_fuel());
        contentValues.put(OrderConst.PAYMENT, order.getPayment());
        contentValues.put(OrderConst.ORDER_NUMBER, order.getOrderNumber());


        return contentValues;
    }




    public static Branch ContentValuesToBranch(ContentValues contentValues) {

        Branch branch = new Branch();
        branch.setCity((contentValues.getAsString(CarConst.BranchConst.CITY)));
        branch.setStreet(contentValues.getAsString(CarConst.BranchConst.STREET));
        branch.setNumber(contentValues.getAsInteger(CarConst.BranchConst.NUMBER));
        branch.setParking_spacees(contentValues.getAsInteger(CarConst.BranchConst.PARKING));
        branch.setBranchNumber(contentValues.getAsInteger(CarConst.BranchConst.BRANCH_NAME));

        return branch;
    }

    public static Car ContentValuesToCar(ContentValues contentValues) {

        Car car = new Car();
        car.setBranchNumber(contentValues.getAsInteger(CarConst.CarsConst.BRANCH_NUMBER));
        car.setModelType(contentValues.getAsString(CarConst.CarsConst.MODEL_TYPE));
        car.setMileage(contentValues.getAsInteger(CarConst.CarsConst.MILEAGE));
        car.setCarNumber(contentValues.getAsInteger(CarConst.CarsConst.CAR_NUMBER));


        return car;
    }


    public static CarModel ContentValuesToCarModel(ContentValues contentValues) {

        CarModel model = new CarModel();
        model.setModelCode(contentValues.getAsString(CarConst.CarModelConst.MODEL_CODE));
        model.setCompany(contentValues.getAsString(CarConst.CarModelConst.COMPANY));
        model.setModelName(contentValues.getAsString(CarConst.CarModelConst.MODEL_NAME));
        model.setEngineCapacity(contentValues.getAsString(CarConst.CarModelConst.ENGINE_CAPACITY));
        model.setGear(Enums.Gear.valueOf(contentValues.getAsString(CarConst.CarModelConst.GEAR)));
        model.setSeatingCapacity(contentValues.getAsInteger(CarConst.CarModelConst.SEATING_CAPICITY));
        model.setDoorsNumber(contentValues.getAsInteger(CarConst.CarModelConst.DOORS_NUMBER));
        model.setEmptyMass(contentValues.getAsString(CarConst.CarModelConst.EMPTY_MASS));
        model.setFuel(contentValues.getAsString(CarConst.CarModelConst.FUEL));
        model.setEngine_type(contentValues.getAsString(CarConst.CarModelConst.ENGINE_TYPE));
        model.setTurbo(Enums.Answer.valueOf(contentValues.getAsString(CarModelConst.TURBO)));
        model.setLighted_makeup_mirror(Enums.Answer.valueOf(contentValues.getAsString(CarModelConst.LIGHTED_MAKEUP_MIRROR)));
        model.setDigital_radio(Enums.Answer.valueOf(contentValues.getAsString(CarModelConst.DIGITAL_RADIO)));
        model.setPanorama(Enums.Answer.valueOf(contentValues.getAsString(CarModelConst.PANORAMA)));
        model.setDriver_airbag(Enums.Answer.valueOf(contentValues.getAsString(CarModelConst.DRIVER_AIRBAG)));
        model.setEmergency_brake_assist(Enums.Answer.valueOf(contentValues.getAsString(CarModelConst.EMERGENCY_BRAKE_ASSIST)));
        model.setTotal_max_power(contentValues.getAsString(CarConst.CarModelConst.TOTAL_MAX_POWER));


        return model;
    }


    public static Client ContentValuesToClient(ContentValues contentValues) {

        Client client = new Client();
        client.setLastName(contentValues.getAsString(CarConst.ClientConst.LAST_NAME));
        client.setFirstName(contentValues.getAsString(CarConst.ClientConst.FIRST_NAME));
        client.setID(contentValues.getAsLong(CarConst.ClientConst.ID));
        client.setPhoneNumber(contentValues.getAsString(CarConst.ClientConst.PHONE_NUMBER));
        client.setMail(contentValues.getAsString(CarConst.ClientConst.MAIL));
        client.setCardNumber(contentValues.getAsString(CarConst.ClientConst.CARD_NUMBER));


        return client;
    }


    public static Order ContentValuesToOrder(ContentValues contentValues) {

        Order order = new Order();
        order.setClientNumber(contentValues.getAsLong(CarConst.OrderConst.CLIENT_NUMBER));
        order.setOrder(Enums.Order.valueOf(contentValues.getAsString(CarConst.OrderConst.ORDER)));
        order.setCarNumber(contentValues.getAsLong(CarConst.OrderConst.CAR_NUMBER));
        order.setRental_srart_date(Date.valueOf(contentValues.getAsString(CarConst.OrderConst.RENTAL_START_DATE)));
        order.setRental_end_date(Date.valueOf(contentValues.getAsString(CarConst.OrderConst.RENTAL_END_DATE)));
        order.setMileage_start_value(contentValues.getAsFloat(CarConst.OrderConst.MILEAGE_START_VALUE));
        order.setMileage_end_value(contentValues.getAsFloat(CarConst.OrderConst.MILEAGE_END_VALUE));
        order.setFuel_filling(contentValues.getAsBoolean(CarConst.OrderConst.FUEL_FILLING));
        order.setQuantity_of_fuel(contentValues.getAsFloat(CarConst.OrderConst.QUANTITY_OF_FUEL));
        order.setPayment(contentValues.getAsFloat(CarConst.OrderConst.PAYMENT));
        order.setOrderNumber(contentValues.getAsLong(CarConst.OrderConst.ORDER_NUMBER));


        return order;
    }









}
