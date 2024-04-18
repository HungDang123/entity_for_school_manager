package com.springboot.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class parent {
    @Id
    @Column(name = "parent_id")
    private String id;
    @Column(columnDefinition = "nvarchar(30)",nullable = false)
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Tên phụ huynh tối thiếu 1 kí tự")
    private String parentName;
    @Column(columnDefinition = "nvarchar(255)")
    private String InfoParent;
    @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
    private student student;

    public parent() {
    }

    public parent(String id, String parentName, String infoParent, com.springboot.project.entity.student student) {
        this.id = id;
        this.parentName = parentName;
        InfoParent = infoParent;
        this.student = student;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getInfoParent() {
        return InfoParent;
    }

    public void setInfoParent(String infoParent) {
        InfoParent = infoParent;
    }

    public com.springboot.project.entity.student getStudent() {
        return student;
    }

    public void setStudent(com.springboot.project.entity.student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "parent{" +
                "id='" + id + '\'' +
                ", parentName='" + parentName + '\'' +
                ", InfoParent='" + InfoParent + '\'' +
                ", student=" + student +
                '}';
    }
}
