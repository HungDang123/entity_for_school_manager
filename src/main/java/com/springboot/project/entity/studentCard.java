package com.springboot.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class studentCard {
    @Id
    @Column(name = "studentCard_id")
    private String id;
    @Column(columnDefinition = "nvarchar(255)")
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Tên học sinh tối thiếu 1 kí tự")
    private String studentName;
    @Column(columnDefinition = "nvarchar(255)")
    private String imageRepresent;
    @Column(columnDefinition = "nvarchar(255)")
    private String info;
    private Double fee;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
    fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private student student;

    public studentCard() {
    }

    public studentCard(String id, String studentName, String imageRepresent, String info, Double fee, com.springboot.project.entity.student student) {
        this.id = id;
        this.studentName = studentName;
        this.imageRepresent = imageRepresent;
        this.info = info;
        this.fee = fee;
        this.student = student;
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

    public String getImageRepresent() {
        return imageRepresent;
    }

    public void setImageRepresent(String imageRepresent) {
        this.imageRepresent = imageRepresent;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public com.springboot.project.entity.student getStudent() {
        return student;
    }

    public void setStudent(com.springboot.project.entity.student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "studentCard{" +
                "id='" + id + '\'' +
                ", studentName='" + studentName + '\'' +
                ", imageRepresent='" + imageRepresent + '\'' +
                ", info='" + info + '\'' +
                ", fee=" + fee +
                ", student=" + student +
                '}';
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
