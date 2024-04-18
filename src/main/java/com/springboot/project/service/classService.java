package com.springboot.project.service;

import com.springboot.project.entity.classs;
import com.springboot.project.entity.school;

import java.util.List;
import java.util.Optional;

public interface classService {
    public List<classs> findAllClass();
    public Optional<classs> findClasslById(String id);
    public classs save(classs classs);
    public classs update(classs classs);
    public void delete(String id);
    public List<Object[]> getClassWithId(String id);
    public List<Object[]> getAllClasses();
    public List<classs> getAllClassBySchool(String id);


}
