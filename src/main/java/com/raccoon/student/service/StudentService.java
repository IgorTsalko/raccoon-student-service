package com.raccoon.student.service;

import com.raccoon.student.model.NewStudentDTO;
import com.raccoon.student.model.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getStudents();

    void saveStudent(NewStudentDTO student);

    StudentDTO getStudent(Long id);
}
