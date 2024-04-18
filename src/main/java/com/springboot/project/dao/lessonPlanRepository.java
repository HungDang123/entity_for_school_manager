package com.springboot.project.dao;

import com.springboot.project.entity.lessonPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface lessonPlanRepository extends JpaRepository<lessonPlan,String> {

}
