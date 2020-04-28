package com.sc.springcreartube.controller;

import com.sc.springccommons.dto.Grade;
import com.sc.springccommons.dto.Student;
import com.sc.springcreartube.service.GradeClient;
import com.sc.springcreartube.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeClient gradeClient;

    @GetMapping("/students")
    public List<Student> selAllStudents(){
        HashMap map=new HashMap();
        return studentService.selStudents();
    }

    //这里调用了eureka-grade的服务，实现了年级信息的查询
    @GetMapping("/gradebyid")
    public Grade selAllGrades(@RequestParam Integer studentId){
        return gradeClient.selGrade(studentId);
    };
}
