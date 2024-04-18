package com.springboot.project.service;

import com.springboot.project.dao.parentRepository;
import com.springboot.project.entity.parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class parentServiceImpl implements parentService{
    parentRepository parentRepository;
@Autowired
    public parentServiceImpl(com.springboot.project.dao.parentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<parent> findAllParent() {
        return parentRepository.findAll();
    }

    @Override
    public Optional<parent> findParentById(String id) {
        return parentRepository.findById(id);
    }

    @Override
    public parent save(parent parent) {
        return parentRepository.saveAndFlush(parent);
    }

    @Override
    public parent update(parent parent) {
        return parentRepository.saveAndFlush(parent);
    }

    @Override
    public void delete(String id) {
            parentRepository.deleteById(id);
    }
}
