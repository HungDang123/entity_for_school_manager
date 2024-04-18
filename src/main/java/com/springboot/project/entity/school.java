package com.springboot.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class school {
    @Id
    @Column(name = "school_id")
    private String id;
    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Tên trường tối thiếu 1 kí tự")
    private String schoolName;
    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Tên địa chỉ tối thiếu 1 kí tự")
    private String address;
    @Column(columnDefinition = "varchar(12)", nullable = false)
    @NotBlank(message = "Không được để trống thông tin")
    private String phoneNumber;
    private String image;
    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String typeOfSchool;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "school")
    public List<classs> list;


    public school() {
    }

    public school(String id, String schoolName, String address, String phoneNumber, String image, String typeOfSchool, List<classs> list) {
        this.id = id;
        this.schoolName = schoolName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.image = image;
        this.typeOfSchool = typeOfSchool;
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "school{" +
                "id='" + id + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", image='" + image + '\'' +
                ", typeOfSchool='" + typeOfSchool + '\'' +
                ", list=" + list +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<classs> getList() {
        return list;
    }

    public void setList(List<classs> list) {
        this.list = list;
    }

    public String getTypeOfSchool() {
        return typeOfSchool;
    }

    public void setTypeOfSchool(String typeOfSchool) {
        this.typeOfSchool = typeOfSchool;
    }
}
