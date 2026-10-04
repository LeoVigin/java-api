package com.iim.javaproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Kit {

//    Define properties of object
    private static int CPT = 1;

    @Id
    @JsonProperty("Id")
    int id;


    @JsonProperty("Color")
    String color;

    @JsonProperty("")
    int maxSpace;

//    Define relationship et return them (not fully set up with person class)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    @JsonProperty("Person")
    private Person person;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "kit_id", insertable = false, updatable = false)
    @JsonProperty("Crayons")
    private List<Crayon> crayons = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "kit_id", insertable = false, updatable = false)
    @JsonProperty("Highlighters")
    private List<Highlighter> highlighters = new ArrayList<>();

    public List<Crayon> getCrayons() { return crayons; }
    public List<Highlighter> getHighlighters() { return highlighters; }

    public Kit() {
    }

//      Constructor
    public Kit(String color) {
        this.id = CPT++;
        this.color = color;
        this.maxSpace = 10;
    }

//    Define set and get for update
    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }

    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }

    public int getId() { return id; }
    public int getMaxSpace() { return maxSpace; }
}
