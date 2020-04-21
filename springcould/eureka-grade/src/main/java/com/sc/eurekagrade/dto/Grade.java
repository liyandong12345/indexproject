package com.sc.eurekagrade.dto;

import lombok.Data;

@Data
public class Grade {
    private Integer id;
    private String grade;
    private String classess;
    private Integer studentId;

    public Grade() {
    }

    public Grade(Integer id, String grade, String classess, Integer studentId) {
        this.id = id;
        this.grade = grade;
        this.classess = classess;
        this.studentId = studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getClassess() {
        return classess;
    }

    public void setClassess(String classess) {
        this.classess = classess;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
