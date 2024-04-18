package com.springboot.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class teacher  {
    @Id
    @Column(name = "username")
    private String username;
    @Column(columnDefinition = "nvarchar(30)", nullable = false)
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Tên giáo viên tối thiếu 1 kí tự")
    private String teacherName;
    @Column(nullable = false)
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Mật khẩu phải tối thiếu 1 kí tự")
    private String password;
    private String role;
    private String images;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
            , fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private classs classs;
    //    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
//            fetch = FetchType.LAZY)
//    @JoinTable(name = "teacher_subject",
//            joinColumns = @JoinColumn(name = "teacher_id"),
//            inverseJoinColumns = @JoinColumn(name = "subject_id"))
//    private List<subject> subject;
    @OneToMany(cascade =  CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "teacher")
    private List<subject> subjects;
    @OneToMany(cascade =  CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "teacher")
    private List<lessonPlan> lessonPlan;

    public teacher() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String id) {
        this.username = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public com.springboot.project.entity.classs getClasss() {
        return classs;
    }

    public void setClasss(com.springboot.project.entity.classs classs) {
        this.classs = classs;
    }

    public teacher(String username, String teacherName, String password, String role, String images, com.springboot.project.entity.classs classs, List<subject> subjects, List<com.springboot.project.entity.lessonPlan> lessonPlan) {
        this.username = username;
        this.teacherName = teacherName;
        this.password = password;
        this.role = role;
        this.images = images;
        this.classs = classs;
        this.subjects = subjects;
        this.lessonPlan = lessonPlan;
    }

    public List<subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<subject> subjects) {
        this.subjects = subjects;
    }

    public List<com.springboot.project.entity.lessonPlan> getLessonPlan() {
        return lessonPlan;
    }

    public void setLessonPlan(List<com.springboot.project.entity.lessonPlan> lessonPlan) {
        this.lessonPlan = lessonPlan;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "username='" + username + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
