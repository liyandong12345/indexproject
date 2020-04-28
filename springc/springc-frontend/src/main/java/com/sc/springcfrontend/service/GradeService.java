package com.sc.springcfrontend.service;

import com.sc.springccommons.dto.Grade;

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
