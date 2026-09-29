package com.iim.javaproject.service;

import com.iim.javaproject.model.Kit;
import com.iim.javaproject.model.Person;
import com.iim.javaproject.repository.KitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitService {

    private final KitRepository kitRepository;

    @Autowired
    public KitService(KitRepository kitRepository){
        this.kitRepository = kitRepository;
    }

    public Kit create(String color, int maxSpace){
        Kit newKit = new Kit(color);
        Kit addKit = kitRepository.save(newKit);
        return addKit;
    }

    public Kit getById(int id){
        Kit kit = kitRepository.findById(id).get();
        return kit;
    }

    public List<Kit> getAll() {
        return kitRepository.findAll();
    }

    public void delete(int id) {
        kitRepository.deleteById(id);
    }

    public Kit update(int id, Kit newDataKit) {
        Kit dataKit = kitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));

        dataKit.setColor(newDataKit.getColor());

        return kitRepository.save(dataKit);
    }
}