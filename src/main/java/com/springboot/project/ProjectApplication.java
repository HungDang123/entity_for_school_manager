package com.springboot.project;

import com.springboot.project.dao.schoolRepository;
import com.springboot.project.dao.teacherRepository;
import com.springboot.project.entity.classs;
import com.springboot.project.entity.school;
import com.springboot.project.entity.teacher;
import com.springboot.project.service.classService;
import com.springboot.project.service.schoolService;
import com.springboot.project.service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ProjectApplication {
    @Autowired
    schoolService schoolService;
    @Autowired
    classService classService;

    public ProjectApplication(com.springboot.project.service.schoolService schoolService, com.springboot.project.service.classService classService) {
        this.schoolService = schoolService;
        this.classService = classService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(teacherRepository teacherRepository) {
        return runner -> {
        };
    }

    public void addClassesToSchools() {
        // Lấy danh sách trường từ cơ sở dữ liệu
        List<school> schools = schoolService.findAllSchool();

        // Lặp qua mỗi trường và thêm 5 lớp cho mỗi trường
        for (school school : schools) {
            for (int i = 1; i <= 5; i++) {
                classs classs = new classs();
                classs.setClassName("ID0 " + i);
                classs.setGrade("Grade " + i);
                classs.setSchoolYear("2024-2025");
                classs.setSchool(school);

                classService.save(classs);
            }
        }
    }

    public void insert(schoolService schoolService) {
        school school = new school();
        school.setId("YD01");
        school.setSchoolName("Trường THCS và THPT Y Đôn");
        school.setAddress("Huyện Đăk Pơ, Tỉnh Gia Lai");
        school.setPhoneNumber("0987654321");
        System.out.println(school.toString());
        schoolService.save(school);
    }
}
