package com.squawk.webapp.models;

import java.text.DecimalFormat;

public class Tag{

    //Atributos
    private Long tagID;
    private String desc;

    //Constructor
    public Tag(Long tagID, String desc) {
        this.tagID = tagID;
        this.desc = desc;
    }

    public Tag() {
    }
    //Getters y Setters

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
}
