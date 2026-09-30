package com.iim.javaproject.service;

import com.iim.javaproject.model.Crayon;
import com.iim.javaproject.repository.CrayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrayonService {

//    Define repository
    private final CrayonRepository crayonRepository;

//    Link service and repository
    @Autowired
    public CrayonService(CrayonRepository crayonRepository){
        this.crayonRepository = crayonRepository;
    }

//  Create the object
    public Crayon create(String color, int length){
//        Create data with data of the constructor
        Crayon newCrayon = new Crayon(color, length);
//        Save data into repository
        Crayon addCrayon = crayonRepository.save(newCrayon);
//        Return data
        return addCrayon;
    }

//  Get of object by its id
    public Crayon getById(int id){
        Crayon crayon = crayonRepository.findById(id).get();
        return crayon;
    }

//  Return every object in its repository
    public List<Crayon> getAll() {
        return crayonRepository.findAll();
    }

//  Delete the object using its id
    public void delete(int id) {
        crayonRepository.deleteById(id);
    }

//  Update the object by using its id
    public Crayon update(int id, Crayon newDataCrayon) {
//          Find the id of the object
        Crayon dataCrayon = crayonRepository.findById(id)
//                  If not found throw error/string
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));

//          If found update the color by the new color put in the raw body of Postman
//          Height cannot be changed
        dataCrayon.setColor(newDataCrayon.getColor());

//          Save the new data into the repository and return it
        return crayonRepository.save(dataCrayon);
    }

}