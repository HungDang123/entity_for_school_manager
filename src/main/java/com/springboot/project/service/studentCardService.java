package com.springboot.project.service;

import com.springboot.project.entity.studentCard;

import java.util.List;
import java.util.Optional;

public interface studentCardService {
    public List<studentCard> findAllStudentCard();
    public Optional<studentCard> findStudentCardById(String id);
    public studentCard save(studentCard studentCard);
    public studentCard update(studentCard studentCard);
    public void delete(String id);
}
