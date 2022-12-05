package com.squawk.webapp.models;

public class LikeCuack {
    private Long id;
    private Cuack cuack;
    private User user;

    public LikeCuack() {
    }

    public LikeCuack(Long id, Cuack cuack, User user) {
        this.id = id;
        this.cuack = cuack;
        this.user = user;
    }

    public LikeCuack(Cuack cuack, User user) {
        this.cuack = cuack;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cuack getCuack() {
        return cuack;
    }

    public void setCuack(Cuack cuack) {
        this.cuack = cuack;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
