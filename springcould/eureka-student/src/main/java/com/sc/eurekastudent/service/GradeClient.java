package com.sc.eurekastudent.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sc.eurekagrade.dto.Grade;
import com.sc.eurekastudent.service.serviceimpl.Gradeclientimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客服端
 */
@Repository
@FeignClient(value = "eureka-grade",fallback = Gradeclientimpl.class)
public interface GradeClient {
    @GetMapping("/gradebyid")
    public Grade selGrade(@RequestParam(value = "studentId", required = true) Integer studentId);


}

