package com.springboot.project.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class lessonPlan {
    @Id
    @Column(name="lessonPlan_id")
    private String id;
    private Date date_teach;
    private String content;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
            ,fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private teacher teacher;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
            ,fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private classs classs;

    public lessonPlan() {
    }

    public lessonPlan(String id, Date date_teach, String content, com.springboot.project.entity.teacher teacher, com.springboot.project.entity.classs classs) {
        this.id = id;
        this.date_teach = date_teach;
        this.content = content;
        this.teacher = teacher;
        this.classs = classs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate_teach() {
        return date_teach;
    }

    public void setDate_teach(Date date_teach) {
        this.date_teach = date_teach;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public com.springboot.project.entity.teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(com.springboot.project.entity.teacher teacher) {
        this.teacher = teacher;
    }

    public com.springboot.project.entity.classs getClasss() {
        return classs;
    }

    public void setClasss(com.springboot.project.entity.classs classs) {
        this.classs = classs;
    }

    @Override
    public String toString() {
        return "lessonPlan{" +
                "id='" + id + '\'' +
                ", date_teach=" + date_teach +
                ", content='" + content + '\'' +
                ", teacher=" + teacher +
                ", classs=" + classs +
                '}';
    }
}
