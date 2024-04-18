package com.springboot.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class subject {
    @Id
    @Column(name="subject_id")
    private String id;
    @Column(columnDefinition = "nvarchar(30)" , nullable = false)
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Tên môn học tối thiếu 1 kí tự")
    private String subjectName;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},
    fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private teacher teacher;

    @OneToMany(cascade =  CascadeType.ALL,
    fetch = FetchType.LAZY,mappedBy = "subject")
    private List<scoreSheet> scoreSheets;
    @OneToMany(cascade =  CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "subject")
    private List<grade> grades;

    public subject() {
    }

    public subject(String id, String subjectName, com.springboot.project.entity.teacher teacher, List<scoreSheet> scoreSheets, List<grade> grades) {
        this.id = id;
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.scoreSheets = scoreSheets;
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public com.springboot.project.entity.teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(com.springboot.project.entity.teacher teacher) {
        this.teacher = teacher;
    }

    public List<scoreSheet> getScoreSheets() {
        return scoreSheets;
    }

    public void setScoreSheets(List<scoreSheet> scoreSheets) {
        this.scoreSheets = scoreSheets;
    }

    public List<grade> getGrades() {
        return grades;
    }

    public void setGrades(List<grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "subject{" +
                "id='" + id + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", teacher=" + teacher +
                ", scoreSheets=" + scoreSheets +
                ", grades=" + grades +
                '}';
    }
}
