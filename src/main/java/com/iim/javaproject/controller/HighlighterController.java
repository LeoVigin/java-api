package com.iim.javaproject.controller;

import com.iim.javaproject.model.Highlighter;
import com.iim.javaproject.model.Kit;
import com.iim.javaproject.model.Person;
import com.iim.javaproject.service.HighlighterService;
import com.iim.javaproject.service.KitService;
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

    private final HighlighterService highlighterService;

    @Autowired
    public HighlighterController(HighlighterService highlighterService){
        this.highlighterService = highlighterService;
    }

    @PostMapping
    public Highlighter create(@RequestParam String color){
        roleUser.forEach(System.out::println);
        return highlighterService.create(color);
    }

    @GetMapping("/{id}")
    public Highlighter getHighlighter(@RequestParam int id){
        return highlighterService.getById(id);
    }

    @GetMapping("/all")
    public List<Highlighter> getAll() {
        return highlighterService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Highlighter> update(@PathVariable("id") int id, @RequestBody Highlighter highlighter) {
        Highlighter updated = highlighterService.update(id, highlighter);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        highlighterService.delete(id);
        return ResponseEntity.ok("Highlighter deleted successfully");
    }
}
