package com.springboot.project.service;

import com.springboot.project.entity.student;

import java.util.List;
import java.util.Optional;

public interface studentService {
    public List<student> findAllStudent();
    public Optional<student> findStudentById(String id);
    public student save(student student);
    public student update(student student);
    public void delete(String id);
}
