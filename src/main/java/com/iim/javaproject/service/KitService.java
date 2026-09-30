package com.iim.javaproject.service;

import com.iim.javaproject.model.Kit;
import com.iim.javaproject.repository.KitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitService {

//    Define repository
    private final KitRepository kitRepository;

//    Link service and repository
    @Autowired
    public KitService(KitRepository kitRepository){
        this.kitRepository = kitRepository;
    }

//  Create the object
    public Kit create(String color, int maxSpace){
//        Create data with data of the constructor
        Kit newKit = new Kit(color);
//        Save data into repository
        Kit addKit = kitRepository.save(newKit);
//        Return data
        return addKit;
    }

//  Get of object by its id
    public Kit getById(int id){
        Kit kit = kitRepository.findById(id).get();
        return kit;
    }

//  Return every object in its repository
    public List<Kit> getAll() {
        return kitRepository.findAll();
    }

//  Delete the object using its id
    public void delete(int id) {
        kitRepository.deleteById(id);
    }

//  Update the object by using its id
    public Kit update(int id, Kit newDataKit) {
//          Find the id of the object
        Kit dataKit = kitRepository.findById(id)
//                  If not found throw error/string
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));

//          If found update the color by the new color put in the raw body of Postman
//          The maximum space cannot be updated, once it is set it cannot be change
        dataKit.setColor(newDataKit.getColor());

//          Save the new data into the repository and return it
        return kitRepository.save(dataKit);
    }
}