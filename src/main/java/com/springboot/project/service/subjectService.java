package com.springboot.project.service;

import com.springboot.project.entity.subject;

import java.util.List;
import java.util.Optional;

public interface subjectService {
    public List<subject> findAllClass();
    public Optional<subject> findClasslById(String id);
    public subject save(subject subject);
    public subject update(subject subject);
    public void delete(String id);
}
