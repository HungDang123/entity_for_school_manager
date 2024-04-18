package com.springboot.project.service;

import com.springboot.project.dao.gradeRepository;
import com.springboot.project.entity.grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class gradeServiceImpl implements gradeService {
    gradeRepository gradeRepository;

    @Autowired
    public gradeServiceImpl(com.springboot.project.dao.gradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<grade> findAllGrade() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional<grade> findGradeById(String id) {
        return gradeRepository.findById(id);
    }

    @Override
    public grade save(grade grade) {
        return gradeRepository.saveAndFlush(grade);
    }

    @Override
    public grade update(grade grade) {
        return gradeRepository.saveAndFlush(grade);
    }

    @Override
    public void delete(String id) {
        gradeRepository.deleteById(id);
    }
}
