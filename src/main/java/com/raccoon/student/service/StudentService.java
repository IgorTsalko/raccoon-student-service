package com.raccoon.student.service;

import com.raccoon.student.model.StudentDTO;
import com.raccoon.student.model.Student;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getStudents();

    void saveStudent(Student student);

    StudentDTO getStudent(Long id);
}
