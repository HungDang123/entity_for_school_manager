package com.springboot.project.service;

import com.springboot.project.entity.grade;

import java.util.List;
import java.util.Optional;

public interface gradeService {
    public List<grade> findAllGrade();
    public Optional<grade> findGradeById(String id);
    public grade save(grade grade);
    public grade update(grade grade);
    public void delete(String id);
}
