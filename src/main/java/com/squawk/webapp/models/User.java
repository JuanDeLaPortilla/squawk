package com.squawk.webapp.models;

import java.time.LocalDate;

public class User {
    //Attributes
    private Long id;
    private String name;
    private LocalDate birthday;
    private String img;
    private int type;
    private int status;
    private LocalDate creationDate;
    private String email;
    private String password;

    //Constructors
    public User(Long id, String name, LocalDate birthday, String img, int type, int status, LocalDate creationDate, String email, String password) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.img = img;
        this.type = type;
        this.status = status;
        this.creationDate = creationDate;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
