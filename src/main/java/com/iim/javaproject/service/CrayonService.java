package com.iim.javaproject.service;

import com.iim.javaproject.model.Crayon;
import com.iim.javaproject.repository.CrayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrayonService {

    private final CrayonRepository crayonRepository;

    @Autowired
    public CrayonService(CrayonRepository crayonRepository){
        this.crayonRepository = crayonRepository;
    }

//  Create
    public Crayon create(String color, int length){
        Crayon newCrayon = new Crayon(color, length);
        Crayon addCrayon = crayonRepository.save(newCrayon);
        return addCrayon;
    }

//  Get ID
    public Crayon getById(int id){
        Crayon crayon = crayonRepository.findById(id).get();
        return crayon;
    }

//  Get All
    public List<Crayon> getAll() {
        return crayonRepository.findAll();
    }

//  Delete
    public void delete(int id) {
        crayonRepository.deleteById(id);
    }

//  Update
    public Crayon update(int id, Crayon newDataCrayon) {
        Crayon dataCrayon = crayonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));

        dataCrayon.setColor(newDataCrayon.getColor());

        return crayonRepository.save(dataCrayon);
    }

}