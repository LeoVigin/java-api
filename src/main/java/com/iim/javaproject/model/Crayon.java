package com.iim.javaproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Crayon implements ToolInterface{

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

//    Suppose to be the elements to form the link between the crayon and the kit. The kit posses the crayons.
    @JsonProperty("Crayon's kit")
    int kit_id;


    //      Constructor
    public Crayon(String color, int length, int kit_id) {
        this.id = CPT++;
        this.color = color;
        this.length = length;
        this.kit_id = kit_id;
    }

//    Define set and get for update
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }

//    Actions set for a Crayon
    public void write(int length, boolean isWriting, boolean isAvailable) {
        if (isWriting) {
            length = length - 1;
            System.out.println(length + " cm is left to write with the pen");
        }

        if (length > 1) {
            System.out.println("This crayon can be writen with");
        } else if (length == 0) {
            System.out.println("This crayon doesnt exist anymore");
        } else {
            System.out.println("This crayon can be difficulty writen with");
        }
    }

//    Check availability from ToolInterface
    @Override
    public void available(boolean using, Person person) {
        if (using) {
            System.out.println(person + " is already using this pen");
        } else {
            System.out.println("Available");
        }
    }
}