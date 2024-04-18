package com.springboot.project.dao;

import com.springboot.project.entity.parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface parentRepository extends JpaRepository<parent,String> {
}
