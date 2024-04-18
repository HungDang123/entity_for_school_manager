package com.springboot.project.controller;

import com.springboot.project.dao.classRepository;
import com.springboot.project.entity.classs;
import com.springboot.project.entity.school;
import com.springboot.project.service.classService;
import com.springboot.project.service.schoolService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/class")
public class ClassController {
    classService classService;
    schoolService schoolService;

    public ClassController(com.springboot.project.service.classService classService, com.springboot.project.service.schoolService schoolService) {
        this.classService = classService;
        this.schoolService = schoolService;
    }

    @GetMapping("/openViewClass/{id}")
    public String openFormClass(@PathVariable String id, Model model) {
        System.out.println("ID: "+id);
       if(id==null){
           List<Object[]> list = classService.getAllClasses();
           model.addAttribute("classes", list);
           return "class/class";
       }else{
           List<Object[]> list = classService.getClassWithId(id);
           model.addAttribute("classes", list);
           return "class/class";
       }
    }
    @GetMapping("/deleteClass/{id}")
    public String deleteClass(@PathVariable String id,Model model){
        Optional<classs> c = classService.findClasslById(id);
        classs classExist;
        if(c!=null){
            classExist = c.get();
            classService.delete(classExist.getId());
        }
        List<Object[]> list = classService.getClassWithId(id);
        model.addAttribute("classes", list);
        return "class/class";
    }
    @PostMapping("/createClass")
    public String createClass(@Valid @ModelAttribute("class") classs registerClass,
                              BindingResult result,
                              Model model,
                              HttpSession session) {
        String username = registerClass.getId();
        String schoolId = registerClass.getSchool().getId();
        if (result.hasErrors()) {
            return "class/formClass";
        }
        Optional<classs> schoolExist = classService.findClasslById(username);
        if (schoolExist.isPresent()) {
            model.addAttribute("class", new school());
            model.addAttribute("my_error", "Lớp đã tồn tại");
            return "class/formClass";
        }
        Optional<school> selectSchool = schoolService.findSchoolById(schoolId);
        classs c = new classs();
        c.setId(registerClass.getId());
        c.setClassName(registerClass.getClassName());
        c.setGrade(registerClass.getGrade());
        c.setSchoolYear(registerClass.getSchoolYear());
        c.setSchool(selectSchool.get());
        classService.save(c);
        model.addAttribute("class", c);
        return "class/formClass";
    }
    @GetMapping("/editClass/{id}")
    public String editClass(@PathVariable String id,Model model){
        Optional<classs> classExist = classService.findClasslById(id);
        classs c = classExist.get();
        model.addAttribute("class",c);
        return "class/formClass";
    }
    @GetMapping("/openFormClass")
    public String openFormClass(Model model){
        List<school> list = schoolService.findAllSchool();
        classs c = new classs();
        model.addAttribute("class",c);
        model.addAttribute("schools",list);
        return "class/formClass";
    }
}
