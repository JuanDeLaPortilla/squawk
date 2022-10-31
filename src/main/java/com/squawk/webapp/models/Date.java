package com.squawk.webapp.models;

public class Date {
    private Long dateID;
    private int month;
    private int year;

    public Date(Long dateID, int month, int year) {
        this.dateID = dateID;
        this.month = month;
        this.year = year;
    }

    public Date() {
    }

    public Long getDateID() {
        return dateID;
    }

    public void setDateID(Long dateID) {
        this.dateID = dateID;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
}
