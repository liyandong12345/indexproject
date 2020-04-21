package com.sc.eurekastudent.controller;

import com.sc.eurekagrade.dto.Grade;
import com.sc.eurekastudent.dto.Student;
import com.sc.eurekastudent.service.GradeClient;
import com.sc.eurekastudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeClient gradeClient;
    public static void main(String[] args) {
        System.out.println(minTeps(1,1,3));
    }
    static int c=0;
    //t 总步数，s 下一步要走的格子数
    public static int add(int t,int s) {
        return t+s;
    }
    public static int del(int t,int s) {
        return t-s;
    }
    public static int minTeps(int t,int s,int m) {
        System.out.println("======>t:"+t+"s:"+s+"m:"+m);
        c+=1;
        if(c<10){

            if(m==t){
                System.out.println("s:"+s);
                return s;
            }else {
                minTeps(add(t,s),s+1,m);
                minTeps(del(t,s),s+1,m);
            }
        }
        return s;
    }

    @GetMapping("/students")
    public List<Student> selAllStudents(){
        HashMap map=new HashMap();
        System.out.println(123);
        return studentService.selStudents();
    }

    //这里调用了eureka-grade的服务，实现了年级信息的查询
    @GetMapping("/gradebyid")
    public Grade selAllGrades(@RequestParam Integer studentId){
        return gradeClient.selGrade(studentId);
    };
}
