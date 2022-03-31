package com.raccoon.learnapp.student.impl.service;

import com.raccoon.learnapp.student.api.Student;
import com.raccoon.learnapp.student.impl.dao.StudentDefinition;
import org.springframework.stereotype.Component;

@Component
public class StudentConvertor {

    public Student convertFormDefinition(StudentDefinition definition) {
        Student student = new Student();
        student.setId(definition.getId());
        student.setFirstName(definition.getFirstName());
        student.setLastName(definition.getLastName());
        student.setEmail(definition.getEmail());
        return student;
    }
}
