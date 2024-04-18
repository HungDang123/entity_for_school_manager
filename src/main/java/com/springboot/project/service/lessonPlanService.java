package com.springboot.project.service;

import com.springboot.project.entity.classs;
import com.springboot.project.entity.lessonPlan;

import java.util.List;
import java.util.Optional;

public interface lessonPlanService {
    public List<lessonPlan> findAllLessonPlan();
    public Optional<lessonPlan> findLessonPlanById(String id);
    public lessonPlan save(lessonPlan lessonPlan);
    public lessonPlan update(lessonPlan lessonPlan);
    public void delete(String id);
}
