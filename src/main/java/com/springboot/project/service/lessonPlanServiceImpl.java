package com.springboot.project.service;

import com.springboot.project.dao.lessonPlanRepository;
import com.springboot.project.entity.lessonPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class lessonPlanServiceImpl implements lessonPlanService {
    lessonPlanRepository lessonPlanRepository;

    @Autowired
    public lessonPlanServiceImpl(com.springboot.project.dao.lessonPlanRepository lessonPlanRepository) {
        this.lessonPlanRepository = lessonPlanRepository;
    }

    @Override
    public List<lessonPlan> findAllLessonPlan() {
        return lessonPlanRepository.findAll();
    }

    @Override
    public Optional<lessonPlan> findLessonPlanById(String id) {
        return lessonPlanRepository.findById(id);
    }

    @Override
    public lessonPlan save(lessonPlan lessonPlan) {
        return lessonPlanRepository.saveAndFlush(lessonPlan);
    }

    @Override
    public lessonPlan update(lessonPlan lessonPlan) {
        return lessonPlanRepository.saveAndFlush(lessonPlan);
    }

    @Override
    public void delete(String id) {
        lessonPlanRepository.deleteById(id);
    }
}
