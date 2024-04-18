package com.springboot.project.service;

import com.springboot.project.dao.subjectRepository;
import com.springboot.project.entity.subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class subjectServiceIml implements subjectService {
    subjectRepository subjectRepository;

    @Autowired
    public subjectServiceIml(com.springboot.project.dao.subjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<subject> findAllClass() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<subject> findClasslById(String id) {
        return subjectRepository.findById(id);
    }

    @Override
    public subject save(subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    @Override
    public subject update(subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    @Override
    public void delete(String id) {
        subjectRepository.deleteById(id);
    }
}
