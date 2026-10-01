package com.iim.javaproject.controller;

import com.iim.javaproject.model.Kit;
import com.iim.javaproject.model.Person;
import com.iim.javaproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Value("${role.user:USER,DEFAULT}")
    private List<String> roleUser;

//    Define service
    private final PersonService personService;

//    Link controller and service
    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

//    Create a person
    @PostMapping
    public Person create(@RequestParam String name, @RequestParam int age, @RequestParam int kit_id){
        roleUser.forEach(System.out::println);
        return personService.create(name, age, kit_id);
    }

//    Get Id of a person
    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") int id) {
        return personService.getById(id);
    }

//    Get all persons
    @GetMapping("/all")
    public List<Person> getAll() {
        return personService.getAll();
    }

//    Update a person's data
    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") int id, @RequestBody Person person) {
        Person updated = personService.update(id, person);
        return ResponseEntity.ok(updated);
    }

//    Delete a person
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        personService.delete(id);
        return ResponseEntity.ok("Person deleted successfully");
    }

}
