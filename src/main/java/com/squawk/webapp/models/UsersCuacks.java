package com.squawk.webapp.models;

public class UsersCuacks {
    private User user;
    private Cuack cuack;

    public UsersCuacks() {
    }

    public UsersCuacks(User user, Cuack cuack) {
        this.user = user;
        this.cuack = cuack;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cuack getCuack() {
        return cuack;
    }

    public void setCuack(Cuack cuack) {
        this.cuack = cuack;
    }
}
