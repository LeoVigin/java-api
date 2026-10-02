package com.iim.javaproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

//    Suppose to be the elements to form the link between the crayon and the kit. The kit posses the highlighters.
    @JsonProperty("Crayon's kit")
    int kit_id;

    public Highlighter() {
    }

//      Constructor
    public Highlighter(String color, int kit_id) {
        this.id = CPT++;
        this.color = color;
        this.kit_id = kit_id;
    }

//    Define set and get for update
    public void setColor(String color){
        this.color = color;
    }
    public void setKitId(int kit_id){
        this.kit_id = kit_id;
    }

    public String getColor(){
        return color;
    }
    public int getKitId(){
        return kit_id;
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
