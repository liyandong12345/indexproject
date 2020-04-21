package com.sc.eurekagrade.controller;

import com.sc.eurekagrade.dto.Grade;
import com.sc.eurekagrade.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/gradebyid")
    public Grade selGrade(@RequestParam(value = "studentId")  Integer studentId){
        System.out.println(123);
        return gradeService.selGrade(studentId);
    }

}
