package com.iim.javaproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Crayon implements PenInterface{

    private static int CPT = 1;
    public Crayon() {}

    @Id
    @JsonProperty("Id")
    int id;

    @JsonProperty("Color")
    String color;

    @JsonProperty("Length")
    int length;

    public Crayon(String color, int length) {
        this.id = CPT++;
        this.color = color;
        this.length = length;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

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

    @Override
    public String toString() {
        return "A " + color + " Crayon";
    }
}