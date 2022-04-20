package com.raccoon.student.impl.controller;

import com.raccoon.student.controller.StudentController;
import com.raccoon.student.service.StudentService;
import com.raccoon.student.model.NewStudentDTO;
import com.raccoon.student.impl.StudentTestData;
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
    private NewStudentDTO newStudentDTO;

    @Test
    void getStudentsTest() {
        studentController.getStudents();
        verify(studentService).getStudents();
    }

    @Test
    void saveStudentTest() {
        ResponseEntity<Object> result = studentController.saveStudent(newStudentDTO);
        assertThat(result).isEqualTo(ResponseEntity.noContent().build());
        verify(studentService).saveStudent(newStudentDTO);
    }

    @Test
    void getStudentTest() {
        studentController.getStudent(StudentTestData.ID);
        verify(studentService).getStudent(StudentTestData.ID);
    }
}