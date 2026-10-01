package com.iim.javaproject.service;

import com.iim.javaproject.model.Person;
import com.iim.javaproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

//    Define repository
    private final PersonRepository personRepository;

//    Link service and repository
    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

//  Create the person
    public Person create(String name, int age, int kit_id){
//        Create data with data of the constructor
        Person newPerson = new Person(name, age, kit_id);
//        Save data into repository
        Person addPerson = personRepository.save(newPerson);
//        Return data
        return addPerson;
    }

//  Get of person by its id
    public Person getById(int id){
        Person person = personRepository.findById(id).get();
        return person;
    }

//  Return every person in its repository
    public List<Person> getAll() {
        return personRepository.findAll();
    }

//  Delete the person using its id
    public void delete(int id) {
        personRepository.deleteById(id);
    }

//  Update the person by using its id
    public Person update(int id, Person newDataPerson) {
//          Find the id of the person
        Person dataPerson = personRepository.findById(id)
//                  If not found throw error/string
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));

//          If found update the name and/or the age by the new name/color put in the raw body of Postman
        dataPerson.setName(newDataPerson.getName());
        dataPerson.setAge(newDataPerson.getAge());

//          Save the new data into the repository and return it
        return personRepository.save(dataPerson);
    }
}
