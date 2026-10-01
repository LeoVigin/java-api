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

//    Suppose to be the elements to form the link between the kit and the person. The person posses the kit.
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="kits_id")
    @JsonProperty("Person's kit id")
    int kit_id;

    public Person() {
    }

//      Constructor
    public Person(String name, int age, int kit_id) {
        this.id = CPT++;
        this.name = name;
        this.age = age;
        this.kit_id = kit_id;
    }

    //    Define set and get for update
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
