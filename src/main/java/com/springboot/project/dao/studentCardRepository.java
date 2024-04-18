package com.springboot.project.dao;

import com.springboot.project.entity.studentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentCardRepository extends JpaRepository<studentCard,String> {
}
