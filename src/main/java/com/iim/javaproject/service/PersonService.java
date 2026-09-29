package com.iim.javaproject.service;

import com.iim.javaproject.model.Person;
import com.iim.javaproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person create(String name, int age){
        Person newPerson = new Person(name, age);
        Person addPerson = personRepository.save(newPerson);
        return addPerson;
    }

    public Person getById(int id){
        Person person = personRepository.findById(id).get();
        return person;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }

    public Person update(int id, Person newDataPerson) {
        Person dataPerson = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));

        dataPerson.setName(newDataPerson.getName());
        dataPerson.setAge(newDataPerson.getAge());

        return personRepository.save(dataPerson);
    }
}
