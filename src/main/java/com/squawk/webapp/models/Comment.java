package com.squawk.webapp.models;

import java.util.Date;

public class Comment {
    //Atributos
    private Long commentID;
    private String desc;
    private double rating;
    private int status;
    private Date creationDate;

    //Constructor
    public Comment(Long commentID, String desc, double rating, int status, Date creationDate) {
        this.commentID = commentID;
        this.desc = desc;
        this.rating = rating;
        this.status = status;
        this.creationDate = creationDate;
    }
    

    public Comment() {
    }

    //Get and Set
    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
}
