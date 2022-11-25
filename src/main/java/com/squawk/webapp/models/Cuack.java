package com.squawk.webapp.models;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Cuack{

    //Atributos
    private Long cuackID;
    private User user;
    private Tag tag;
    private String content;
    private String img;
    private String url;
    private int status;
    private String title;
    private LocalDateTime creationDate;
    private int isEdited;

    private int likes;

    //Constructor
    public Cuack() {
    }

    //Get and Set

    public Long getCuackID() {
        return cuackID;
    }

    public void setCuackID(Long cuackID) {
        this.cuackID = cuackID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public int isEdited() {return isEdited;}

    public void setEdited(int edited) {this.isEdited = edited;}

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
