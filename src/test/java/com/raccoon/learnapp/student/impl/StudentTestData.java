package com.raccoon.learnapp.student.impl;

import com.raccoon.learnapp.student.impl.dao.entity.StudentEntity;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;

public class StudentTestData {

    public static final Long ID = 1L;
    public static final String FIRST_NAME = "Name";
    public static final String LAST_NAME = "Surname";
    public static final String LOGIN = "Login";
    public static final String EMAIL = "email@gmail.com";
    public static final String PASSWORD = "password12345";
    public static final Integer LEVEL = 5;

    public static StudentEntity generateStudentEntity() {
        StudentEntity entity = new StudentEntity();
        entity.setId(ID);
        entity.setFirstName(FIRST_NAME);
        entity.setLastName(LAST_NAME);
        entity.setLogin(LOGIN);
        entity.setEmail(EMAIL);
        entity.setLevel(LEVEL);
        return entity;
    }

    public static StudentRegistrationData generateRegistrationData() {
        StudentRegistrationData data = new StudentRegistrationData();
        data.setFirstName(FIRST_NAME);
        data.setLastName(LAST_NAME);
        data.setLogin(LOGIN);
        data.setEmail(EMAIL);
        data.setPassword(PASSWORD);
        return data;
    }
}
