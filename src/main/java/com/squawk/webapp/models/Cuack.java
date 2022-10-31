package com.squawk.webapp.models;

import java.text.DecimalFormat;
import java.util.Date;

public class Cuack{

    //Atributos
    private Long cuackID;
    private Long tagID;
    private String desc;
    private String img;
    private String url;
    private double rating;
    private int status;
    private String title;
    private double price;
    private Date creationDate;
    private int edited;

    //Constructor
    public Cuack(Long cuackID, Long tagID, String desc, String img, String url, double rating, int status, String title, double price, Date creationDate, int edited) {
        this.cuackID = cuackID;
        this.tagID = tagID;
        this.desc = desc;
        this.img = img;
        this.url = url;
        this.rating = rating;
        this.status = status;
        this.title = title;
        this.price = price;
        this.creationDate = creationDate;
        this.edited = edited;
    }

    public Cuack() {
    }

    //Get and Set

    public Long getCuackID() {
        return cuackID;
    }

    public void setCuackID(Long cuackID) {
        this.cuackID = cuackID;
    }

    public Long getTagID() {
        return tagID;
    }

    public void setTagID(Long tagID) {
        this.tagID = tagID;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getEdited() {
        return edited;
    }

    public void setEdited(int edited) {
        this.edited = edited;
    }
    
}
