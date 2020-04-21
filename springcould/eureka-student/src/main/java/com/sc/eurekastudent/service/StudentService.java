package com.sc.eurekastudent.service;

import com.sc.eurekastudent.dto.Student;

import java.util.List;

public interface  StudentService {
    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> selStudents();
}
