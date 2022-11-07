package com.squawk.webapp.models;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;

public class Cuack{

    //Atributos
    private Long cuackID;
    private Tag tag;
    private String desc;
    private String img;
    private String url;
    private double rating;
    private int status;
    private String title;
    private double price;
    private LocalDate creationDate;
    private int isEdited;

    //Constructor
    public Cuack(Long cuackID, Tag tag, String desc, String img, String url, double rating, int status, String title, double price, LocalDate creationDate, int edited) {
        this.cuackID = cuackID;
        this.tag = tag;
        this.desc = desc;
        this.img = img;
        this.url = url;
        this.rating = rating;
        this.status = status;
        this.title = title;
        this.price = price;
        this.creationDate = creationDate;
        this.isEdited = edited;
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int isEdited() {return isEdited;}

    public void setEdited(int edited) {this.isEdited = edited;}
    
}
