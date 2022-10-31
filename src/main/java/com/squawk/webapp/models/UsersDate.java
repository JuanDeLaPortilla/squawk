package com.squawk.webapp.models;

public class UsersDate {
    private Long userID;
    private Long dateID;

    public UsersDate(Long userID, Long dateID) {
        this.userID = userID;
        this.dateID = dateID;
    }

    public UsersDate() {
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getDateID() {
        return dateID;
    }

    public void setDateID(Long dateID) {
        this.dateID = dateID;
    }
    
}
