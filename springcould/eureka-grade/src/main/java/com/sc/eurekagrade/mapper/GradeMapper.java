package com.sc.eurekagrade.mapper;

import com.sc.eurekagrade.dto.Grade;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GradeMapper {
    @Select("select * from grade where studentid=#{studentId}")
    Grade selGrade(Integer studentId);
}
