package com.iim.javaproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Highlighter implements PenInterface {

//    Define properties of object
    private static int CPT = 1;

    @Id
    @JsonProperty("Id")
    int id;

    @JsonProperty("Color")
    String color;

    public Highlighter() {
    }

//      Constructor
    public Highlighter(String color) {
        this.id = CPT++;
        this.color = color;
    }

//    Define set and get for update
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }

//    Actions set for a Highlighter
    public void write(boolean ink){
        if (ink){
            System.out.println("This highlighter can be writen with");
        }
        else {
            System.out.println("This highlighter doesn't have any ink to write with");
        }
    }

    public void leak(boolean inkExplode){
        if (inkExplode){
            System.out.println("This highlighter ink exploded");
        }
        else {
            System.out.println("This highlighter can be writen with");
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
