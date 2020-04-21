package com.sc.eurekagrade.service;

import com.sc.eurekagrade.dto.Grade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface GradeService {
    /**
     * 查询所有学生信息
     * @return
     */
    Grade selGrade(Integer studentId);
    List<Map<String, Object>> testDowngrade();
}
