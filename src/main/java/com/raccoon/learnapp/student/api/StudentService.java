package com.raccoon.learnapp.student.api;

import com.raccoon.learnapp.student.impl.model.Student;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getStudents();

    void saveStudent(Student student);

    StudentDTO getStudent(Long id);
}
