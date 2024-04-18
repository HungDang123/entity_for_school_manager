package com.springboot.project.dao;

import com.springboot.project.entity.grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface gradeRepository extends JpaRepository<grade,String> {
}
