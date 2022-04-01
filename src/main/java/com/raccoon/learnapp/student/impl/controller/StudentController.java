package com.raccoon.learnapp.student.impl.controller;

import com.raccoon.learnapp.student.api.StudentService;
import com.raccoon.learnapp.student.api.Student;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        //todo: add logging for all services
        return studentService.getStudents();
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Object> signUp(@RequestBody StudentRegistrationData studentRegistrationData) {
        studentService.signUpStudent(studentRegistrationData);
        return ResponseEntity.noContent().build();
    }
}
