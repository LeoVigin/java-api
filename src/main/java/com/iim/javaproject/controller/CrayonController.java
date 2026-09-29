package com.iim.javaproject.controller;

import com.iim.javaproject.model.Crayon;
import com.iim.javaproject.model.Kit;
import com.iim.javaproject.model.Person;
import com.iim.javaproject.service.CrayonService;
import com.iim.javaproject.service.KitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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
    public Crayon create(@RequestParam String color, @RequestParam int length){
        roleUser.forEach(System.out::println);
        return crayonService.create(color, length);
    }

    @GetMapping("/{id}")
    public Crayon getById(@RequestParam int id) {
        return crayonService.getById(id);
    }

    @GetMapping("/all")
    public List<Crayon> getAll() {
        return crayonService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crayon> update(@PathVariable("id") int id, @RequestBody Crayon crayon) {
        Crayon updated = crayonService.update(id, crayon);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        crayonService.delete(id);
        return ResponseEntity.ok("Highlighter deleted successfully");
    }
}