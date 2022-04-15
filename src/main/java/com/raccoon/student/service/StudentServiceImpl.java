package com.raccoon.student.service;

import com.raccoon.student.dao.StudentRepository;
import com.raccoon.student.dao.entity.StudentEntity;
import com.raccoon.student.exception.StudentDoesNotExistException;
import com.raccoon.student.model.StudentDTO;
import com.raccoon.student.model.Student;
import com.raccoon.student.service.mapper.StudentMapper;
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
    public void saveStudent(Student student) {
        log.debug("Save new student: {}", student);
        StudentEntity entity = studentMapper.convertToEntity(student);
        studentRepository.save(entity);
    }

    @Override
    public StudentDTO getStudent(Long id) {
        log.debug("Retrieve student by id: {}", id);
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> {
            log.error("Student with id: {} does not exist", id);
            throw new StudentDoesNotExistException(id);
        });
        return studentMapper.convertToDTO(studentEntity);
    }
}
