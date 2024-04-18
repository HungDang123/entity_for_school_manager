package com.springboot.project.entity;

import jakarta.persistence.*;

@Entity
public class grade {
    @Id
    @Column(name = "grade_id")
    private String id;
    private String period;
    private Double mark;
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private student student;
    @ManyToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private subject subject;

    public grade() {
    }

    public grade(String id, String period, Double mark, com.springboot.project.entity.student student, com.springboot.project.entity.subject subject) {
        this.id = id;
        this.period = period;
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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
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
        return "grade{" +
                "id='" + id + '\'' +
                ", period='" + period + '\'' +
                ", mark=" + mark +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }
}
