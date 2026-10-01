package com.iim.javaproject.service;

import com.iim.javaproject.model.Highlighter;
import com.iim.javaproject.repository.HighlighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighlighterService {

//    Define repository
    private final HighlighterRepository highlighterRepository;

//    Link service and repository
    @Autowired
    public HighlighterService(HighlighterRepository highlighterRepository){
        this.highlighterRepository = highlighterRepository;
    }

//  Create the object
    public Highlighter create(String color, int kit_id){
//        Create data with data of the constructor
        Highlighter newHighlighter = new Highlighter(color, kit_id);
//        Save data into repository
        Highlighter addHighlighter = highlighterRepository.save(newHighlighter);
//        Return data
        return addHighlighter;
    }

//  Get of object by its id
    public Highlighter getById(int id){
        Highlighter highlighter = highlighterRepository.findById(id).get();
        return highlighter;
    }

//  Return every object in its repository
    public List<Highlighter> getAll() {
        return highlighterRepository.findAll();
    }

//  Delete the object using its id
    public void delete(int id) {
        highlighterRepository.deleteById(id);
    }

//  Update the object by using its id
    public Highlighter update(int id, Highlighter newDataHighlighter) {
//          Find the id of the object
        Highlighter dataHighlighter = highlighterRepository.findById(id)
//                  If not found throw error/string
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));

//          If found update the color by the new color and/or id put in the raw body of Postman
        dataHighlighter.setColor(newDataHighlighter.getColor());

//          Save the new data into the repository and return it
        return highlighterRepository.save(dataHighlighter);
    }
}
