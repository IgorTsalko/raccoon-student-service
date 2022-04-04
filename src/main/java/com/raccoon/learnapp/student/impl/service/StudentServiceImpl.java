package com.raccoon.learnapp.student.impl.service;

import com.raccoon.learnapp.student.api.StudentService;
import com.raccoon.learnapp.student.api.Student;
import com.raccoon.learnapp.student.impl.dao.StudentDefinition;
import com.raccoon.learnapp.student.impl.dao.StudentRepository;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentConvertor studentConvertor;

    @Override
    public List<Student> getStudents() {
        log.debug("Retrieve all users");
        return studentRepository.findAll().stream()
                .map(studentConvertor::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void signUpStudent(StudentRegistrationData data) {
        log.debug("Sign up a new user: {}", data);
        StudentDefinition definition = studentConvertor.convert(data);
        studentRepository.save(definition);
    }
}
