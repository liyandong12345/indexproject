package com.sc.springcfrontend.mapper;

import com.sc.springccommons.dto.Grade;
import org.springframework.stereotype.Component;

@Component
public interface GradeMapper {
    Grade selGrade(Integer studentId);
}
