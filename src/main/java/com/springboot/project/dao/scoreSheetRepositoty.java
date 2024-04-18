package com.springboot.project.dao;

import com.springboot.project.entity.scoreSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface scoreSheetRepositoty extends JpaRepository<scoreSheet,String> {
}
