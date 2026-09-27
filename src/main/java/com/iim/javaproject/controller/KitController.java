package com.iim.javaproject.controller;

import com.iim.javaproject.model.Crayon;
import com.iim.javaproject.model.Kit;
import com.iim.javaproject.model.PenInterface;
import com.iim.javaproject.service.CrayonService;
import com.iim.javaproject.service.KitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/kit")
public class KitController {

    @Value("${role.user:USER,DEFAULT}")
    private List<String> roleUser;

    private final KitService kitService;

    @Autowired
    public KitController(KitService kitService){
        this.kitService = kitService;
    }

    @PostMapping
    public Kit create(@RequestParam String color, @RequestParam int maxSpace){
        roleUser.forEach(System.out::println);
        return kitService.create(color, maxSpace);
    }

    @GetMapping
    public Kit getById(@RequestParam int id) {
        return kitService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        kitService.delete(id);
        return ResponseEntity.ok("Person deleted successfully!");
    }
    //    Update

//    Delete

}