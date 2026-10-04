package com.iim.javaproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Highlighter implements ToolInterface {

//    Define properties of object
    private static int CPT = 1;

    @Id
    @JsonProperty("Id")
    int id;

    @JsonProperty("Color")
    String color;

//  Relation with kit
    @Column(name = "kit_id")
    @JsonProperty("KitId")
    private int kitId;

    //      Constructor
    public Highlighter(String color, int kitId) {
        this.id = CPT++;
        this.color = color;
        this.kitId = kitId;
    }

    //    Define set and get for update
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }

    public int getKitId() { return kitId; }
    public void setKitId(int kitId) { this.kitId = kitId; }

//    Actions set for a Highlighter
    public void write(boolean ink){
        if (ink){
            System.out.println("This highlighter can be writen with");
        }
        else {
            System.out.println("This highlighter doesn't have any ink to write with");
        }
    }

//    Check availability from ToolInterface
    @Override
    public void available(boolean using, Person person) {
        if (using) {
            System.out.println(String.valueOf(person) + " is already using this pen");
        } else {
            System.out.println("Available");
        }
    }
}
