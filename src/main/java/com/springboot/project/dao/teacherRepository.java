package com.springboot.project.dao;

import com.springboot.project.entity.teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface teacherRepository extends JpaRepository<teacher,String> {
    public Optional<teacher> findByUsername(String username);
}
