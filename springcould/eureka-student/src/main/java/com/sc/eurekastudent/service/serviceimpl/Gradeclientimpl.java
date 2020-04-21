package com.sc.eurekastudent.service.serviceimpl;

import com.sc.eurekagrade.dto.Grade;
import com.sc.eurekastudent.service.GradeClient;
import org.springframework.stereotype.Component;

@Component
public class Gradeclientimpl implements GradeClient {

    @Override
    public Grade selGrade(Integer studentId) {
        Grade g=new Grade();
        g.setClassess("无");
        return g;
    }
}
