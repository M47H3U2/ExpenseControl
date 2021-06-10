package com.example.prototypofinance.pojos;

import java.io.Serializable;

public class Expense_POJO implements Serializable {

    private String datetime;
    //private int time;
    private String accountName;
    private String type;
    private int value;
    private String description;

    public Expense_POJO() {
    }

    public Expense_POJO(String datetime, String accountName, String type, int value, String description) {
        this.datetime = datetime;
        this.accountName = accountName;
        this.type = type;
        this.value = value;
        this.description = description;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

