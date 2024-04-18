package com.springboot.project.service;

import com.springboot.project.dao.scoreSheetRepositoty;
import com.springboot.project.entity.scoreSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class scoreSheetServiceImpl implements scoreSheetService {
    scoreSheetRepositoty scoreSheetRepositoty;

    @Autowired
    public scoreSheetServiceImpl(com.springboot.project.dao.scoreSheetRepositoty scoreSheetRepositoty) {
        this.scoreSheetRepositoty = scoreSheetRepositoty;
    }

    @Override
    public List<scoreSheet> findAllClass() {
        return scoreSheetRepositoty.findAll();
    }

    @Override
    public Optional<scoreSheet> findScoreSheetById(String id) {
        return scoreSheetRepositoty.findById(id);
    }

    @Override
    public scoreSheet save(scoreSheet scoreSheet) {
        return scoreSheetRepositoty.saveAndFlush(scoreSheet);
    }

    @Override
    public scoreSheet update(scoreSheet scoreSheet) {
        return scoreSheetRepositoty.saveAndFlush(scoreSheet);
    }

    @Override
    public void delete(String id) {
            scoreSheetRepositoty.deleteById(id);
    }
}
