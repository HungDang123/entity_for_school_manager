package com.springboot.project.controller;

import com.springboot.project.entity.teacher;
import com.springboot.project.service.teacherService;
import com.springboot.project.service.teacherServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping()
public class loginController {
    private teacherService teacherService;

    @Autowired
    public loginController(com.springboot.project.service.teacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/showPage403")
    public String showPage403() {
        return "error/403";
    }
}
