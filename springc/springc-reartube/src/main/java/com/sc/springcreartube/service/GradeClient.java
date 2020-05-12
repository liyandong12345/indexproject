package com.sc.springcreartube.service;

import com.sc.springccommons.dto.Grade;
import com.sc.springcreartube.service.serviceimpl.Gradeclientimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 客服端
 */
@Repository
@FeignClient(value = "springc-frontend",fallback = Gradeclientimpl.class)
public interface GradeClient {
    @GetMapping("/gradebyid")
    public Grade selGrade(@RequestParam(value = "studentId", required = true) Integer studentId);


}

