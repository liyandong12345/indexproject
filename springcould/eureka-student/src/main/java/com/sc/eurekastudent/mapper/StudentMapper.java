package com.sc.eurekastudent.mapper;

import com.sc.eurekastudent.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> selStudents();
}
