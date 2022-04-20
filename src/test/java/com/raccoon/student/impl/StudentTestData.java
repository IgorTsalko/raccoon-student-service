package com.raccoon.student.impl;

import com.raccoon.student.dao.entity.StudentEntity;
import com.raccoon.student.model.NewStudentDTO;

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

    public static NewStudentDTO generateNewStudentDTO() {
        NewStudentDTO newStudentDTO = new NewStudentDTO();
        newStudentDTO.setFirstName(FIRST_NAME);
        newStudentDTO.setLastName(LAST_NAME);
        newStudentDTO.setLogin(LOGIN);
        newStudentDTO.setEmail(EMAIL);
        newStudentDTO.setPassword(PASSWORD);
        return newStudentDTO;
    }
}
