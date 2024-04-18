package com.springboot.project.dao;

import com.springboot.project.entity.subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface subjectRepository extends JpaRepository<subject,String> {
}
