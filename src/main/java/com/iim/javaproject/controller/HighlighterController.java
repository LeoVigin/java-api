package com.iim.javaproject.controller;

import com.iim.javaproject.model.Highlighter;
import com.iim.javaproject.service.HighlighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/highlighter")
public class HighlighterController {

    @Value("${role.user:USER,DEFAULT}")
    private List<String> roleUser;

//    Define service
    private final HighlighterService highlighterService;

//    Link controller and service
    @Autowired
    public HighlighterController(HighlighterService highlighterService){
        this.highlighterService = highlighterService;
    }

//    Create an object
    @PostMapping
    public Highlighter create(@RequestParam String color){
        roleUser.forEach(System.out::println);
        return highlighterService.create(color);
    }

//    Get Id of an object
    @GetMapping("/{id}")
    public Highlighter getHighlighter(@RequestParam int id){
        return highlighterService.getById(id);
    }

//    Get all objects
    @GetMapping("/all")
    public List<Highlighter> getAll() {
        return highlighterService.getAll();
    }

//    Update the object
    @PutMapping("/{id}")
    public ResponseEntity<Highlighter> update(@PathVariable("id") int id, @RequestBody Highlighter highlighter) {
        Highlighter updated = highlighterService.update(id, highlighter);
        return ResponseEntity.ok(updated);
    }

//    Delete the object
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        highlighterService.delete(id);
        return ResponseEntity.ok("Highlighter deleted successfully");
    }
}
