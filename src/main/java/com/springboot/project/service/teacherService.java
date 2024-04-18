package com.springboot.project.service;

import org.springframework.security.core.userdetails.User;
import com.springboot.project.entity.teacher;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface teacherService extends UserDetailsService {
    public List<teacher> findAllTeacher();
    public Optional<teacher> findTeacherByUsername(String id);
    public teacher save(teacher teacher);
    public teacher update(teacher teacher);
    public void delete(String id);

}
