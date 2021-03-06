package com.example.prototypofinance.pojos;

import java.io.Serializable;
import java.sql.Date;

public class Account_POJO implements Serializable {

    private String date;
    private String name;
    private String category;
    private int value;

    public Account_POJO() {
    }

    public Account_POJO(String date, String name, String category, int value) {
        this.date = date;
        this.name = name;
        this.category = category;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
