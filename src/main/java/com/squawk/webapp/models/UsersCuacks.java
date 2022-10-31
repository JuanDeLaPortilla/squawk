package com.squawk.webapp.models;

public class UsersCuacks {
    private Long userID;
    private Long cuackID;

    public UsersCuacks(Long userID, Long cuackID) {
        this.userID = userID;
        this.cuackID = cuackID;
    }

    public UsersCuacks() {
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getCuackID() {
        return cuackID;
    }

    public void setCuackID(Long cuackID) {
        this.cuackID = cuackID;
    }
    
}
