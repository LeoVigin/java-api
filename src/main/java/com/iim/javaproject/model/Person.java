package com.iim.javaproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {

    private static int CPT = 1;

    @Id
    @JsonProperty("id")
    int id;

    @JsonProperty("Name")
    String name;

    @JsonProperty("Age")
    int age;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="kits_id")
    private List<Kit> kits_id;

    public Person() {
    }

    public Person(String name, int age) {
        this.id = CPT++;
        this.name = name;
        this.age = age;
//        this.kits_id = kits_id;
    }
}
