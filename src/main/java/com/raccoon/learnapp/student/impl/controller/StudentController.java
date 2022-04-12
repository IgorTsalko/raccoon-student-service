package com.raccoon.learnapp.student.impl.controller;

import com.raccoon.learnapp.student.api.StudentService;
import com.raccoon.learnapp.student.api.StudentDTO;
import com.raccoon.learnapp.student.impl.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDTO> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Object> signUp(@RequestBody Student data) {
        studentService.saveStudent(data);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }
}
