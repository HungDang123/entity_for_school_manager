package com.springboot.project.service;

import com.springboot.project.entity.reportCard;

import java.util.List;
import java.util.Optional;

public interface reportCardService {
    public List<reportCard> findAllReportCard();
    public Optional<reportCard> findReportCardById(String id);
    public reportCard save(reportCard reportCard);
    public reportCard update(reportCard reportCard);
    public void delete(String id);
}
