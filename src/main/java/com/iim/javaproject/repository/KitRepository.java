package com.iim.javaproject.repository;

import com.iim.javaproject.model.Kit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitRepository extends JpaRepository<Kit, Integer> {;
}
