package com.squawk.webapp.models;

public class LikeCuack {
    private Long likeCuackID;
    private Long userID;
    private Long cuackID;

    public LikeCuack(Long likeCuackID, Long userID, Long cuackID) {
        this.likeCuackID = likeCuackID;
        this.userID = userID;
        this.cuackID = cuackID;
    }

    public LikeCuack() {
    }

    public Long getLikeCuackID() {
        return likeCuackID;
    }

    public void setLikeCuackID(Long likeCuackID) {
        this.likeCuackID = likeCuackID;
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
