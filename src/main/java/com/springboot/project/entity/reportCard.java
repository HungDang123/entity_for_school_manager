package com.springboot.project.entity;

import jakarta.persistence.*;

@Entity
public class reportCard {
    @Id
    private String id;
    private double mark;
    private String conduct;
    private String feedback;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private student student;

    public reportCard() {
    }

    public reportCard(String id, double mark, String conduct, String feedback, com.springboot.project.entity.student student) {
        this.id = id;
        this.mark = mark;
        this.conduct = conduct;
        this.feedback = feedback;
        this.student = student;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public com.springboot.project.entity.student getStudent() {
        return student;
    }

    public void setStudent(com.springboot.project.entity.student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "reportCard{" +
                "id='" + id + '\'' +
                ", mark=" + mark +
                ", conduct='" + conduct + '\'' +
                ", feedback='" + feedback + '\'' +
                ", student=" + student +
                '}';
    }
}
