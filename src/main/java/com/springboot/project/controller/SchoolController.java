package com.springboot.project.controller;

import com.springboot.project.entity.school;
import com.springboot.project.service.ImageStorageService;
import com.springboot.project.service.schoolService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/school")
public class SchoolController {
    private ImageStorageService storageService;
    schoolService schoolService;

    @Autowired
    public SchoolController(com.springboot.project.service.schoolService schoolService, ImageStorageService storageService) {
        this.schoolService = schoolService;
        this.storageService = storageService;
    }

    @InitBinder
    public void initBinder(WebDataBinder data) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        data.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/openViewSchool")
    public String openViewSchool(Model model) {
        List<Object[]> list = schoolService.getSchool();
//        list.forEach(s-> System.out.println(s[1]+" ,"+s[2]));
        model.addAttribute("school", list);
        return "school/school";
    }

    @GetMapping("/openFormSchool")
    public String openFormSchool(Model model) {
        school s = new school();
        model.addAttribute("school", s);
        return "school/formSchool";
    }

    @PostMapping("/createSchool")
    public String createSchool(@Valid @ModelAttribute("school") school registerSchool,
                               @RequestParam("imageInput") MultipartFile file,
                               BindingResult result,
                               Model model,
                               HttpSession session) {
        String username = registerSchool.getId();
        if (result.hasErrors()) {
            return "school/formSchool";
        }
        Optional<school> schoolExist = schoolService.findSchoolById(username);
        if (schoolExist.isPresent()) {
            model.addAttribute("school", new school());
            model.addAttribute("my_error", "Trường đã tồn tại");
            return "school/formSchool";
        }
        school school = new school();
        school.setId(registerSchool.getId());
        school.setSchoolName(registerSchool.getSchoolName());
        school.setAddress(registerSchool.getAddress());
        school.setPhoneNumber(registerSchool.getPhoneNumber());
        school.setTypeOfSchool(registerSchool.getTypeOfSchool());
        if (!file.isEmpty()) {
            try {
                String generateFilename = storageService.storeFile(file);
                System.out.println(generateFilename);
                school.setImage(generateFilename);
            } catch (Exception e) {
                System.out.println("Upload file images " + e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println(school.toString());
        schoolService.save(school);
        model.addAttribute("school", school);
        return "school/formSchool";
    }

    @GetMapping("/file/{fileName:.+}")
    public byte[] readDetailFile(@PathVariable String fileName) {
        byte[] bytes = storageService.readFileContent(fileName);
        return bytes;
    }

    @GetMapping("/editSchool/{id}")
    public String updateSchool(@PathVariable String id, Model model) {
        Optional<school> s = schoolService.findSchoolById(id);
        school school = s.get();
        model.addAttribute("school", school);
        return "school/formSchool";
    }

    @GetMapping("/deleteSchool/{id}")
    public String deleteSchool(@PathVariable String id, Model model) {
        Optional<school> s = schoolService.findSchoolById(id);
        school school = s.get();
        if (school != null) {
            schoolService.delete(school.getId());
        }
        List<Object[]> list = schoolService.getSchool();
        model.addAttribute("school", list);
        return "school/school";
    }
}
