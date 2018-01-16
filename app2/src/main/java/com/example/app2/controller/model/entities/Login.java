package com.example.app2.controller.model.entities;

/**
 * Created by Shirly on 12/26/2017.
 */

public class Login {
    private String User;
    private String Password;
    private int clientNumber;

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
