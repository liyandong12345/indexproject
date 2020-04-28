package com.sc.springcreartube.service.serviceimpl;

import com.sc.springccommons.dto.Student;
import com.sc.springcreartube.mapper.StudentMapper;
import com.sc.springcreartube.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> selStudents() {
        return studentMapper.selStudents();
    }
}
