package com.iim.javaproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Kit {

    private static int CPT = 1;

    @Id
    @JsonProperty("id")
    int id;


    @JsonProperty("color")
    String color;

    @JsonProperty("")
    int maxSpace;

    private Integer personId;

    public Kit() {
    }

    public Kit(String color) {
        this.id = CPT++;
        this.color = color;
        this.maxSpace = 10;
    }
}
