package com.raccoon.learnapp.student.impl.service;

import com.raccoon.learnapp.student.api.StudentService;
import com.raccoon.learnapp.student.api.Student;
import com.raccoon.learnapp.student.impl.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentConvertor studentConvertor;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentConvertor studentConvertor) {
        this.studentRepository = studentRepository;
        this.studentConvertor = studentConvertor;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll().stream()
                .map(studentConvertor::convertFormDefinition)
                .collect(Collectors.toList());
    }
}
