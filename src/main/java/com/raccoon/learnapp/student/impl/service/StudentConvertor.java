package com.raccoon.learnapp.student.impl.service;

import com.raccoon.learnapp.student.api.Student;
import com.raccoon.learnapp.student.impl.dao.StudentDefinition;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;
import org.springframework.stereotype.Component;

@Component
public class StudentConvertor {

    public Student convert(StudentDefinition definition) {
        Student student = new Student();
        student.setId(definition.getId());
        student.setFirstName(definition.getFirstName());
        student.setLastName(definition.getLastName());
        student.setLogin(definition.getLogin());
        student.setEmail(definition.getEmail());
        return student;
    }

    public StudentDefinition convert(StudentRegistrationData data) {
        StudentDefinition definition = new StudentDefinition();
        definition.setFirstName(data.getFirstName());
        definition.setLastName(data.getLastName());
        definition.setLogin(data.getLogin());
        definition.setEmail(data.getEmail());
        definition.setPassword(data.getPassword());
        return definition;
    }
}
