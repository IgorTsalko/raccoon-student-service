package com.raccoon.learnapp.student.impl.controller;

import com.raccoon.learnapp.student.api.StudentService;
import com.raccoon.learnapp.student.impl.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @Mock
    private Student registrationData;

    @Test
    void getStudentsTest() {
        studentController.getStudents();
        verify(studentService).getStudents();
    }

    @Test
    void signUpTest() {
        ResponseEntity<Object> result = studentController.signUp(registrationData);
        assertThat(result).isEqualTo(ResponseEntity.noContent().build());
        verify(studentService).saveStudent(registrationData);
    }
}