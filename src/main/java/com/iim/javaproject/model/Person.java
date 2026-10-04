package com.iim.javaproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {

//    Define properties of object
    private static int CPT = 1;

    @Id
    @JsonProperty("Id")
    int id;

    @JsonProperty("Name")
    String name;

    @JsonProperty("Age")
    int age;

//    Get the kit linked with
    @Column(name = "kit_id")
    @JsonProperty("KitId")
    int kitId;

    public Person() {
    }

//      Constructor
    public Person(String name, int age, int kitId) {
        this.id = CPT++;
        this.name = name;
        this.age = age;
        this.kitId = kitId;
    }

    //    Define set and get for update
    public int getId() { return id; }

    public int getKitId() { return kitId; }
    public void setKitId(int kitId) { this.kitId = kitId; }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
