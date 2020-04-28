package com.sc.springcreartube.mapper;

import com.sc.springccommons.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> selStudents();
}
