package com.springboot.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class student {
    @Id
    @Column(name = "student_id")
    private String id;
    @Column(columnDefinition = "nvarchar(30)")
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Tên học sinh tối thiếu 1 kí tự")
    private String studentName;
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Mật khẩu phải tối thiếu 1 kí tự")
    private String password;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private classs classs;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private parent parent;
    @OneToMany(cascade =  CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "student")
    private List<grade> grades;

    @OneToMany(cascade =  CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "student")
    private List<reportCard> reportCards;

    @OneToMany(cascade =  CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "student")
    private List<scoreSheet> scoreSheets;

    @OneToMany(cascade =  CascadeType.ALL,
            fetch = FetchType.LAZY,mappedBy = "student")
    private List<studentCard> studentCards;
    public student() {
    }

    public student(String id, String studentName, String password, com.springboot.project.entity.classs classs, com.springboot.project.entity.parent parent, List<grade> grades, List<reportCard> reportCards, List<scoreSheet> scoreSheets, List<studentCard> studentCards) {
        this.id = id;
        this.studentName = studentName;
        this.password = password;
        this.classs = classs;
        this.parent = parent;
        this.grades = grades;
        this.reportCards = reportCards;
        this.scoreSheets = scoreSheets;
        this.studentCards = studentCards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public com.springboot.project.entity.classs getClasss() {
        return classs;
    }

    public void setClasss(com.springboot.project.entity.classs classs) {
        this.classs = classs;
    }

    public com.springboot.project.entity.parent getParent() {
        return parent;
    }

    public void setParent(com.springboot.project.entity.parent parent) {
        this.parent = parent;
    }

    public List<grade> getGrades() {
        return grades;
    }

    public void setGrades(List<grade> grades) {
        this.grades = grades;
    }

    public List<reportCard> getReportCards() {
        return reportCards;
    }

    public void setReportCards(List<reportCard> reportCards) {
        this.reportCards = reportCards;
    }

    public List<scoreSheet> getScoreSheets() {
        return scoreSheets;
    }

    public void setScoreSheets(List<scoreSheet> scoreSheets) {
        this.scoreSheets = scoreSheets;
    }

    public List<studentCard> getStudentCards() {
        return studentCards;
    }

    public void setStudentCards(List<studentCard> studentCards) {
        this.studentCards = studentCards;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "student{" +
                "id='" + id + '\'' +
                ", studentName='" + studentName + '\'' +
                ", password='" + password + '\'' +
                ", classs=" + classs +
                ", parent=" + parent +
                ", grades=" + grades +
                ", reportCards=" + reportCards +
                ", scoreSheets=" + scoreSheets +
                ", studentCards=" + studentCards +
                '}';
    }
}
