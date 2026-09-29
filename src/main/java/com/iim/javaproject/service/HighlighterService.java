package com.iim.javaproject.service;

import com.iim.javaproject.model.Highlighter;
import com.iim.javaproject.model.Kit;
import com.iim.javaproject.model.Person;
import com.iim.javaproject.repository.HighlighterRepository;
import com.iim.javaproject.repository.KitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighlighterService {

    private final HighlighterRepository highlighterRepository;

    @Autowired
    public HighlighterService(HighlighterRepository highlighterRepository){
        this.highlighterRepository = highlighterRepository;
    }

    public Highlighter create(String color){
        Highlighter newHighlighter = new Highlighter(color);
        Highlighter addHighlighter = highlighterRepository.save(newHighlighter);
        return addHighlighter;
    }

    public Highlighter getById(int id){
        Highlighter highlighter = highlighterRepository.findById(id).get();
        return highlighter;
    }

    public List<Highlighter> getAll() {
        return highlighterRepository.findAll();
    }

    public void delete(int id) {
        highlighterRepository.deleteById(id);
    }

    public Highlighter update(int id, Highlighter newDataHighlighter) {
        Highlighter dataHighlighter = highlighterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));

        dataHighlighter.setColor(newDataHighlighter.getColor());

        return highlighterRepository.save(dataHighlighter);
    }
}
