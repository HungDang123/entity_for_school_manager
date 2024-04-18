package com.springboot.project.controller;

import com.springboot.project.entity.school;
import com.springboot.project.entity.teacher;
import com.springboot.project.service.schoolService;
import com.springboot.project.service.teacherService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping()
public class homeController {

    private final HttpServletRequest httpServletRequest;
    teacherService teacherService;
    @Autowired
    public homeController(HttpServletRequest httpServletRequest,teacherService teacherService) {
        this.httpServletRequest = httpServletRequest;
        this.teacherService = teacherService;
    }

    @GetMapping()
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/people")
    public String peopleForm(Model model) {
        return "/router/people";
    }

    @GetMapping("/schedule")
    public String scheduleForm(Model model) {
        return "/router/schedule";
    }

    @GetMapping("/profile")
    public String profileForm(Model model, Principal principal,  HttpServletRequest request) {
        String username = principal.getName();
        Optional<teacher> optionalTeacher = teacherService.findTeacherByUsername(username);  // Assuming this is the corrected method name
        if (!optionalTeacher.isPresent()) {
            // Handle user not found
            return "redirect:/index";
        }

        teacher teacher = optionalTeacher.get();
        HttpSession httpSession = request.getSession();  // Now HttpServletRequest is autowired and used correctly
        httpSession.setAttribute("loggedInUser", teacher);
        return "/router/profile";
    }

}
