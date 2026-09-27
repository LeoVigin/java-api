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

    @PostMapping
    public Person create(@RequestParam String name, @RequestParam int age){
        roleUser.forEach(System.out::println);
        return personService.create(name, age);
    }

    @GetMapping
    public Person getById(@RequestParam int id) {
        return personService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        personService.delete(id);
        return ResponseEntity.ok("Person deleted successfully!");
    }

//    http://localhost:8080/person?name=leo&age=20

//    Update
//@PutMapping
//public Person update(@RequestParam int id, @RequestParam String name, @RequestParam int age) {
//    return personService.update(id, name, age);
//}

//    Delete
}
