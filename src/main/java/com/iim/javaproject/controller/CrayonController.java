package com.iim.javaproject.controller;

import com.iim.javaproject.model.Crayon;
import com.iim.javaproject.model.Kit;
import com.iim.javaproject.service.CrayonService;
import com.iim.javaproject.service.KitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crayon")
public class CrayonController {

    @Value("${role.user:USER,DEFAULT}")
    private List<String> roleUser;

    private final CrayonService crayonService;

    @Autowired
    public CrayonController(CrayonService crayonService){
        this.crayonService = crayonService;
    }

    @PostMapping
    public Crayon create(@RequestParam String color){
        roleUser.forEach(System.out::println);
        return crayonService.create(color);
    }

    @GetMapping
    public Crayon getById(@RequestParam int id) {
        return crayonService.getById(id);
    }

//    Update

//    Delete
}