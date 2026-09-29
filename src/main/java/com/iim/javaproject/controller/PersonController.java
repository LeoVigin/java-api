package com.iim.javaproject.controller;

import com.iim.javaproject.model.Kit;
import com.iim.javaproject.model.Person;
import com.iim.javaproject.repository.PersonRepository;
import com.iim.javaproject.service.KitService;
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

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    //    Create object
    @PostMapping
    public Person create(@RequestParam String name, @RequestParam int age){
        roleUser.forEach(System.out::println);
        return personService.create(name, age);
    }

    //    Get Id of object
    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") int id) {
        return personService.getById(id);
    }

    //    Get all objects
    @GetMapping("/all")
    public List<Person> getAll() {
        return personService.getAll();
    }

    //    Update of object
    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") int id, @RequestBody Person person) {
        Person updated = personService.update(id, person);
        return ResponseEntity.ok(updated);
    }

    //    Delete an object
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        personService.delete(id);
        return ResponseEntity.ok("Person deleted successfully");
    }

}
