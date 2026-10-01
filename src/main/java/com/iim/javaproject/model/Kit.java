package com.iim.javaproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Kit {

//    Define properties of object
    private static int CPT = 1;

    @Id
    @JsonProperty("Id")
    int id;


    @JsonProperty("Color")
    String color;

    @JsonProperty("")
    int maxSpace;

    public Kit() {
    }

//      Constructor
    public Kit(String color) {
        this.id = CPT++;
        this.color = color;
        this.maxSpace = 10;
    }

//    Define set and get for update
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
}
