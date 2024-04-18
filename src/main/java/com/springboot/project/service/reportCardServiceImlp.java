package com.springboot.project.service;

import com.springboot.project.dao.reportCardRepository;
import com.springboot.project.entity.reportCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class reportCardServiceImlp implements reportCardService {
    reportCardRepository reportCardRepository;

    @Autowired
    public reportCardServiceImlp(com.springboot.project.dao.reportCardRepository reportCardRepository) {
        this.reportCardRepository = reportCardRepository;
    }

    @Override
    public List<reportCard> findAllReportCard() {
        return reportCardRepository.findAll();
    }

    @Override
    public Optional<reportCard> findReportCardById(String id) {
        return reportCardRepository.findById(id);
    }

    @Override
    public reportCard save(reportCard reportCard) {
        return reportCardRepository.saveAndFlush(reportCard);
    }

    @Override
    public reportCard update(reportCard reportCard) {
        return reportCardRepository.saveAndFlush(reportCard);
    }

    @Override
    public void delete(String id) {
        reportCardRepository.deleteById(id);
    }
}
