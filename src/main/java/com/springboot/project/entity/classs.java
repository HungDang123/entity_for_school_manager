package com.springboot.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class classs {
    @Id
    @Column(name = "class_id")
    private String id;
    @Column(columnDefinition = "nvarchar(30)", nullable = false)
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Tên lớp tối thiếu 1 kí tự")
    private String className;
    @Column(columnDefinition = "nvarchar(30)", nullable = false)
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Tên khối tối thiếu 1 kí tự")
    private String grade;
    @Column(columnDefinition = "nvarchar(30)", nullable = false)
    @NotBlank(message = "Không được để trống thông tin")
    @Size(min = 1, message = "Niên học tối thiếu 1 kí tự")
    private String schoolYear;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private school school;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "classs")
    private List<teacher> teacher;
    @OneToMany(cascade =  CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "classs")
    private List<student> students;

    @OneToMany(cascade =  CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "classs")
    private List<lessonPlan> lessonPlans;

    public classs(String id, String className, String grade, String schoolYear, com.springboot.project.entity.school school, List<com.springboot.project.entity.teacher> teacher, List<student> students, List<lessonPlan> lessonPlans) {
        this.id = id;
        this.className = className;
        this.grade = grade;
        this.schoolYear = schoolYear;
        this.school = school;
        this.teacher = teacher;
        this.students = students;
        this.lessonPlans = lessonPlans;
    }

    public classs() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public com.springboot.project.entity.school getSchool() {
        return school;
    }

    public void setSchool(com.springboot.project.entity.school school) {
        this.school = school;
    }

    public List<com.springboot.project.entity.teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<com.springboot.project.entity.teacher> teacher) {
        this.teacher = teacher;
    }

        @Override
        public String toString() {
            return "classs{" +
                    "id='" + id + '\'' +
                    ", className='" + className + '\'' +
                    ", grade='" + grade + '\'' +
                    ", schoolYear='" + schoolYear + '\'' +
//                    ", school=" + school +
                    ", teacher=" + teacher +
    //                ", students=" + students +
    //                ", lessonPlans=" + lessonPlans +
                    '}';
        }

    public List<lessonPlan> getLessonPlans() {
        return lessonPlans;
    }

    public void setLessonPlans(List<lessonPlan> lessonPlans) {
        this.lessonPlans = lessonPlans;
    }

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }
}
