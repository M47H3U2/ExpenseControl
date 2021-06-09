package com.example.prototypofinance.pojos;

import java.io.Serializable;

public class Transfer_POJO implements Serializable {

    private String date;
    //private int time;
    private String accountGive;
    private String accountTake;
    private String description;
    private String value;

    public Transfer_POJO() {
    }

    public Transfer_POJO(String date, String accountGive, String accountTake, String description, String value) {
        this.date = date;
        this.accountGive = accountGive;
        this.accountTake = accountTake;
        this.description = description;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccountGive() {
        return accountGive;
    }

    public void setAccountGive(String accountGive) {
        this.accountGive = accountGive;
    }

    public String getAccountTake() {
        return accountTake;
    }

    public void setAccountTake(String accountTake) {
        this.accountTake = accountTake;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

