package com.squawk.webapp.models;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class countByMonth{

    //Atributos
    private String mes;
    private int cant;

    //Constructor
    public countByMonth() {
    }

    //Get and Set

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    
}
