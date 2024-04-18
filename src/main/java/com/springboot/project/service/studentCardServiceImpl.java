package com.springboot.project.service;

import com.springboot.project.dao.studentCardRepository;
import com.springboot.project.entity.studentCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class studentCardServiceImpl implements studentCardService{
    studentCardRepository studentCardRepository;
    @Autowired
    public studentCardServiceImpl(com.springboot.project.dao.studentCardRepository studentCardRepository) {
        this.studentCardRepository = studentCardRepository;
    }

    @Override
    public List<studentCard> findAllStudentCard() {
        return studentCardRepository.findAll();
    }

    @Override
    public Optional<studentCard> findStudentCardById(String id) {
        return studentCardRepository.findById(id);
    }

    @Override
    public studentCard save(studentCard studentCard) {
        return studentCardRepository.saveAndFlush(studentCard);
    }

    @Override
    public studentCard update(studentCard studentCard) {
        return studentCardRepository.saveAndFlush(studentCard);
    }

    @Override
    public void delete(String id) {
        studentCardRepository.deleteById(id);
    }
}
