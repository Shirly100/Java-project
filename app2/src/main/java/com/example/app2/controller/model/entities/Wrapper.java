package com.example.app2.controller.model.entities;

import java.util.List;

/**
 * Created by Shirly on 1/7/2018.
 */

public class Wrapper {
    public String dec;
    public List<String> list;
    public String adress;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
