package com.iim.javaproject.repository;

import com.iim.javaproject.model.Highlighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighlighterRepository extends JpaRepository<Highlighter, Integer> {;
//    All data related to highlighters are set and retrieved here.
}
