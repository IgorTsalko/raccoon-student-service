package com.raccoon.learnapp.student.impl.service;

import com.raccoon.learnapp.student.api.Student;
import com.raccoon.learnapp.student.impl.dao.entity.StudentEntity;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;
import org.springframework.stereotype.Component;

@Component
public class StudentConvertor {

    public Student convert(StudentEntity entity) {
        Student student = new Student();
        student.setId(entity.getId());
        student.setFirstName(entity.getFirstName());
        student.setLastName(entity.getLastName());
        student.setLogin(entity.getLogin());
        student.setEmail(entity.getEmail());
        student.setLevel(entity.getLevel());
        return student;
    }

    public StudentEntity convert(StudentRegistrationData data) {
        StudentEntity entity = new StudentEntity();
        entity.setFirstName(data.getFirstName());
        entity.setLastName(data.getLastName());
        entity.setLogin(data.getLogin());
        entity.setEmail(data.getEmail());
        entity.setPassword(data.getPassword());
        return entity;
    }
}
