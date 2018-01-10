package com.example.app2.controller.model.entities;

/**
 * Created by Shirly on 11/12/2017.
 */

public class Client
{
    private String  lastName;
    private String firstName;
    private long _id;
    private String  phoneNumber;
    private String mail;
    private String cardNumber;

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getID() {
        return _id;
    }

    public void setID(long ID) {
        this._id = ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
