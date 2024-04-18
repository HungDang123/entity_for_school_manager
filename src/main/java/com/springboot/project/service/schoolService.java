package com.springboot.project.service;

import com.springboot.project.entity.school;

import java.util.List;
import java.util.Optional;

public interface schoolService {
public List<school> findAllSchool();
public Optional<school> findSchoolById(String id);
public school save(school school);
public school update(school school);
public void delete(String id);
public List<Object[]> getSchool();
}
