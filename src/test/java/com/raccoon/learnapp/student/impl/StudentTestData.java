package com.raccoon.learnapp.student.impl;

import com.raccoon.learnapp.student.impl.dao.StudentDefinition;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;

public class StudentTestData {

    public static final Long ID = 1L;
    public static final String FIRST_NAME = "Name";
    public static final String LAST_NAME = "Surname";
    public static final String LOGIN = "Login";
    public static final String EMAIL = "email@gmail.com";
    public static final String PASSWORD = "password12345";
    public static final Integer LEVEL = 5;

    public static StudentDefinition generateStudentDef() {
        StudentDefinition definition = new StudentDefinition();
        definition.setId(ID);
        definition.setFirstName(FIRST_NAME);
        definition.setLastName(LAST_NAME);
        definition.setLogin(LOGIN);
        definition.setEmail(EMAIL);
        definition.setLevel(LEVEL);
        return definition;
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
