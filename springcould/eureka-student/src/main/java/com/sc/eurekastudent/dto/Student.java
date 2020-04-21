package com.sc.eurekastudent.dto;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer grade;

    public Student() {
    }

    public Student(Integer id, String name, String sex, Integer grade) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
