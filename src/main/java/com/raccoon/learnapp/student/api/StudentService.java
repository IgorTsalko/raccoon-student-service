package com.raccoon.learnapp.student.api;

import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getStudents();

    void signUpStudent(StudentRegistrationData studentRegistrationData);
}
