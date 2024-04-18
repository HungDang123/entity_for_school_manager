package com.springboot.project.service;

import com.springboot.project.entity.parent;

import java.util.List;
import java.util.Optional;

public interface parentService {
    public List<parent> findAllParent();
    public Optional<parent> findParentById(String id);
    public parent save(parent parent);
    public parent update(parent parent);
    public void delete(String id);
}
