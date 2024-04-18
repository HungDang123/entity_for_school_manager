package com.springboot.project.dao;

import com.springboot.project.entity.reportCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reportCardRepository extends JpaRepository<reportCard,String> {
}
