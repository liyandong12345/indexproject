package com.sc.eurekastudent.service.serviceimpl;

import com.sc.eurekastudent.dto.Student;
import com.sc.eurekastudent.mapper.StudentMapper;
import com.sc.eurekastudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selStudents() {
        return studentMapper.selStudents();
    }
}
