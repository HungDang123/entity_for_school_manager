package com.springboot.project.service;

import com.springboot.project.dao.classRepository;
import com.springboot.project.entity.classs;
import com.springboot.project.entity.school;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class classServiceImpl implements classService {
    classRepository classRepository;

    @Autowired
    public classServiceImpl(com.springboot.project.dao.classRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public List<classs> findAllClass() {
        return classRepository.findAll();
    }

    @Override
    public Optional<classs> findClasslById(String id) {
        return classRepository.findById(id);
    }

    @Override
    public classs save(classs classs) {
        return classRepository.saveAndFlush(classs);
    }

    @Override
    public classs update(classs classs) {
        return classRepository.saveAndFlush(classs);
    }

    @Override
    public void delete(String id) {
        classRepository.deleteById(id);
    }

    @Override
    public List<Object[]> getClassWithId(String id) {
        return classRepository.findAllClasssWithStudentCount(id);
    }
    @Override
    public List<Object[]> getAllClasses() {
        return classRepository.findAllClasssWithStudentCount();
    }
    @Override
    public List<classs> getAllClassBySchool(String id){
        return classRepository.findAllBySchoolId(id);
    }
}
