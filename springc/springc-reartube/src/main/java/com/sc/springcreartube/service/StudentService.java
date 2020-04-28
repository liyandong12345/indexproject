package com.sc.springcreartube.service;


import com.sc.springccommons.dto.Student;

import java.util.List;

public interface  StudentService {
    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> selStudents();
}
