package com.example.prototypofinance.pojos;

import java.io.Serializable;

public class Income_POJO implements Serializable {

    private String date;
    //private int time;
    private String accountName;
    private String type;
    private String value;
    private String description;

    public Income_POJO() {
    }

    public Income_POJO(String date, String accountName, String type, String value, String description) {
        this.date = date;
        this.accountName = accountName;
        this.type = type;
        this.value = value;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
