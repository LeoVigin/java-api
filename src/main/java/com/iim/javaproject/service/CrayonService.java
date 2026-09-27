package com.iim.javaproject.service;

import com.iim.javaproject.model.Crayon;
import com.iim.javaproject.model.Kit;
import com.iim.javaproject.repository.CrayonRepository;
import com.iim.javaproject.repository.KitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class CrayonService {

    private final CrayonRepository crayonRepository;

    @Autowired
    public CrayonService(CrayonRepository crayonRepository){
        this.crayonRepository = crayonRepository;
    }

    public List<Crayon> getAllCrayons() {
        return crayonRepository.findAll();
    }

    public Crayon create(String color){
        Crayon newCrayon = new Crayon(color);
        Crayon addCrayon = crayonRepository.save(newCrayon);
        return addCrayon;
//        return new Crayon(id, color);
    }

//    public Crayon update(String color){
//        Crayon crayon.color = new color;
//    }

    public Crayon getById(int id){
        Crayon crayon = crayonRepository.findById(id).get();
        return crayon;
    }

}
