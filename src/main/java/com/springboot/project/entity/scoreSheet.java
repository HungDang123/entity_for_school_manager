package com.springboot.project.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class scoreSheet {
    @Id
    @Column(name = "scoreSheet_id")
    private String id;
    @Column(name = "date_check")
    private Date date;
    private double mark;
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private student student;
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private subject subject;

    public scoreSheet() {
    }

    public scoreSheet(String id, Date date, double mark, com.springboot.project.entity.student student, com.springboot.project.entity.subject subject) {
        this.id = id;
        this.date = date;
        this.mark = mark;
        this.student = student;
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public com.springboot.project.entity.student getStudent() {
        return student;
    }

    public void setStudent(com.springboot.project.entity.student student) {
        this.student = student;
    }

    public com.springboot.project.entity.subject getSubject() {
        return subject;
    }

    public void setSubject(com.springboot.project.entity.subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "scoreSheet{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", mark=" + mark +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }
}
