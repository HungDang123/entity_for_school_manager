package com.springboot.project.controller;

import com.springboot.project.entity.classs;
import com.springboot.project.entity.school;
import com.springboot.project.entity.student;
import com.springboot.project.exception.ResponseObject;
import com.springboot.project.service.classService;
import com.springboot.project.service.schoolService;
import com.springboot.project.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    studentService studentService;
//    classService classService;
//    schoolService schoolService;

//    @Autowired
//    public StudentController(com.springboot.project.service.studentService studentService) {
//        this.studentService = studentService;
//    }

//    @GetMapping("/openViewStudent")
//    public String openViewStudent(Model model) {
//        List<student> list = studentService.findAllStudent();
//        model.addAttribute("students", list);
//        return "student/students";
//    }
//
//    @GetMapping("/openFormStudent")
//    public String openFormStudent(Model model) {
//        List<school> list = schoolService.findAllSchool();
//        student c = new student();
//        model.addAttribute("student", c);
//        model.addAttribute("schools", list);
//        return "student/formStudent";
//    }
//
//    @GetMapping("/changeSchool/{id}")
//    public String changeSchool(@PathVariable String id, Model model) {
//        System.out.println("ID: " + id);
//        if (id.equals("null")) {
//            return "student/formStudent";
//        } else {
//            List<classs> classses = classService.getAllClassBySchool(id);
//            student student = new student();
//            model.addAttribute("student", student);
//            model.addAttribute("changeSchool", classses);
//            return "student/formStudent";
//        }
//    }
    @PostMapping("/createStudent")
    public ResponseEntity<ResponseObject> createStudent(@RequestBody student newStudent){
        Optional<student> studentExist = studentService.findStudentById(newStudent.getId());
        System.out.println(HttpStatus.OK.name());
        if(!studentExist.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(HttpStatus.OK.name(), "Thêm thành công",studentService.save(newStudent))
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Thêm thất bại","")
            );
        }
    }
}
