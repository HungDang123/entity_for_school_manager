package com.springboot.project.service;

import com.springboot.project.entity.scoreSheet;

import java.util.List;
import java.util.Optional;

public interface scoreSheetService {
    public List<scoreSheet> findAllClass();
    public Optional<scoreSheet> findScoreSheetById(String id);
    public scoreSheet save(scoreSheet scoreSheet);
    public scoreSheet update(scoreSheet scoreSheet);
    public void delete(String id);
}
