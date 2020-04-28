package com.sc.springcfrontend.controller;

import com.sc.springccommons.dto.Grade;
import com.sc.springcfrontend.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/gradebyid")
    public Grade selGrade(@RequestParam(value = "studentId")  Integer studentId){
        return gradeService.selGrade(studentId);
    }

}
