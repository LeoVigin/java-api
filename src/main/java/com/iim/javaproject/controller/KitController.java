package com.iim.javaproject.controller;

import com.iim.javaproject.model.Kit;
import com.iim.javaproject.service.KitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kit")
public class KitController {

    @Value("${role.user:USER,DEFAULT}")
    private List<String> roleUser;

//    Define service
    private final KitService kitService;

//    Link controller and service
    @Autowired
    public KitController(KitService kitService){
        this.kitService = kitService;
    }

//    Create an object
    @PostMapping
    public Kit create(@RequestParam String color, @RequestParam int maxSpace){
        roleUser.forEach(System.out::println);
        return kitService.create(color, maxSpace);
    }

//    Get Id of an object
    @GetMapping("/{id}")
    public Kit getById(@RequestParam int id) {
        return kitService.getById(id);
    }

//    Get all objects
    @GetMapping("/all")
    public List<Kit> getAll() {
        return kitService.getAll();
    }

//    Update the object
    @PutMapping("/{id}")
    public ResponseEntity<Kit> update(@PathVariable("id") int id, @RequestBody Kit kit) {
        Kit updated = kitService.update(id, kit);
        return ResponseEntity.ok(updated);
    }

//    Delete the object
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        kitService.delete(id);
        return ResponseEntity.ok("Kit deleted successfully");
    }
}