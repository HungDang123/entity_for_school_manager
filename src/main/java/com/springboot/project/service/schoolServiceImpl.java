package com.springboot.project.service;

import com.springboot.project.dao.schoolRepository;
import com.springboot.project.entity.school;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class schoolServiceImpl implements schoolService {
    schoolRepository schoolRepository;

    @Autowired
    public schoolServiceImpl(com.springboot.project.dao.schoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<school> findAllSchool() {
        return schoolRepository.findAll();
    }

    @Override
    public Optional<school> findSchoolById(String id) {
        return schoolRepository.findById(id);
    }

    @Override
    public school save(school school) {
        return schoolRepository.saveAndFlush(school);
    }

    @Override
    public school update(school school) {
        return schoolRepository.saveAndFlush(school);
    }

    @Override
    public void delete(String id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public List<Object[]> getSchool() {
        return schoolRepository.findAllSchoolWithStudentCount();
    }


}
