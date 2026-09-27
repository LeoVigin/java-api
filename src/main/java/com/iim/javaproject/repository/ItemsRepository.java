package com.iim.javaproject.repository;

import com.iim.javaproject.model.Crayon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Crayon, Integer> {;
}
