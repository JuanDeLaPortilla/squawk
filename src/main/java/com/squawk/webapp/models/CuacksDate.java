package com.squawk.webapp.models;

public class CuacksDate {
    private Long cuackID;
    private Long dateID;

    public CuacksDate(Long cuackID, Long dateID) {
        this.cuackID = cuackID;
        this.dateID = dateID;
    }

    public CuacksDate() {
    }

    public Long getCuackID() {
        return cuackID;
    }

    public void setCuackID(Long cuackID) {
        this.cuackID = cuackID;
    }

    public Long getDateID() {
        return dateID;
    }

    public void setDateID(Long dateID) {
        this.dateID = dateID;
    }
    
    
}
