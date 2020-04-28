package com.sc.springcreartube.service.serviceimpl;

import com.sc.springccommons.dto.Grade;
import com.sc.springcreartube.service.GradeClient;
import org.springframework.stereotype.Component;

@Component
public class Gradeclientimpl implements GradeClient {

    public Grade selGrade(Integer studentId) {
        Grade g=new Grade();
        g.setClassess("无");
        return g;
    }
}
