package com.raccoon.learnapp.student.impl.service;

import com.raccoon.learnapp.student.api.StudentService;
import com.raccoon.learnapp.student.api.StudentDTO;
import com.raccoon.learnapp.student.impl.dao.entity.StudentEntity;
import com.raccoon.learnapp.student.impl.dao.StudentRepository;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;
import com.raccoon.learnapp.student.impl.service.mapper.StudentMapper;
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
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDTO> getStudents() {
        log.debug("Retrieve all students");
        return studentRepository.findAll().stream()
                .map(studentMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void signUpStudent(StudentRegistrationData data) {
        log.debug("Sign up a new student: {}", data);
        StudentEntity entity = studentMapper.convertToEntity(data);
        studentRepository.save(entity);
    }

    @Override
    public StudentDTO getStudent(Long id) {
        log.debug("Retrieve student by id: {}", id);
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow();
        return studentMapper.convertToDTO(studentEntity);
    }
}
