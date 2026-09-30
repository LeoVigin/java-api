package com.iim.javaproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Crayon implements PenInterface{

//    Define properties of object
    private static int CPT = 1;
    public Crayon() {}

    @Id
    @JsonProperty("Id")
    int id;

    @JsonProperty("Color")
    String color;

    @JsonProperty("Length")
    int length;

//      Constructor
    public Crayon(String color, int length) {
        this.id = CPT++;
        this.color = color;
        this.length = length;
    }

//    Define set and get for update
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }

//    Actions set for a Crayon
    public void write(int length) {
        if (length > 10) {
            System.out.println("This crayon can be writen with");
        } else if (length == 0) {
            System.out.println("This crayon doesnt exist anymore");
        } else {
            System.out.println("This crayon can be difficulty writen with");
        }
    }

    @Override
    public void available(boolean using, Person person) {
        if (using) {
            System.out.println(String.valueOf(person) + " is already using this pen");
        } else {
            System.out.println("Available");
        }
    }
}