package com.springboot.project.service;

import com.springboot.project.dao.teacherRepository;
import com.springboot.project.entity.teacher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class teacherServiceImpl implements teacherService {
    teacherRepository teacherRepository;
    private final HttpServletRequest httpServletRequest;
    @Autowired
    public teacherServiceImpl(com.springboot.project.dao.teacherRepository teacherRepository,HttpServletRequest httpServletRequest) {
        this.teacherRepository = teacherRepository;
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public List<teacher> findAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<teacher> findTeacherByUsername(String username) {
        return teacherRepository.findByUsername(username);
    }
    @Override
    public teacher save(teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public teacher update(teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public void delete(String id) {
            teacherRepository.deleteById(id);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<teacher> optionalTeacher = teacherRepository.findByUsername(username);
        teacher teacher = optionalTeacher.orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));

        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("loggedInUser", teacher);

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(teacher.getRole()));
        return new User(teacher.getUsername(), teacher.getPassword(), authorities);
    }
}
