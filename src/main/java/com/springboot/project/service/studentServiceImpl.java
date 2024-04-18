package com.springboot.project.service;

import com.springboot.project.dao.studentRepository;
import com.springboot.project.entity.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class studentServiceImpl implements studentService {
    studentRepository studentRepository;

    @Autowired
    public studentServiceImpl(com.springboot.project.dao.studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<student> findStudentById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public student save(student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public student update(student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void delete(String id) {
            studentRepository.deleteById(id);
    }
}
