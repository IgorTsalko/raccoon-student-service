package com.raccoon.learnapp.student.impl.service;

import com.raccoon.learnapp.student.api.StudentDTO;
import com.raccoon.learnapp.student.impl.dao.entity.StudentEntity;
import com.raccoon.learnapp.student.impl.dao.StudentRepository;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;
import com.raccoon.learnapp.student.impl.service.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @Test
    void shouldReturnStudents() {
        // given
        StudentEntity studentDef = new StudentEntity();
        StudentDTO student = new StudentDTO();

        when(studentRepository.findAll()).thenReturn(List.of(studentDef));
        when(studentMapper.convertToDTO(studentDef)).thenReturn(student);

        // when
        List<StudentDTO> result = studentService.getStudents();

        // then
        assertThat(result).asList().containsExactly(student);
        verify(studentRepository).findAll();
        verify(studentMapper).convertToDTO(studentDef);
    }

    @Test
    void shouldSignUpStudent() {
        // given
        StudentRegistrationData registrationData = new StudentRegistrationData();
        StudentEntity studentDef = new StudentEntity();

        when(studentMapper.convertToEntity(registrationData)).thenReturn(studentDef);

        // when
        studentService.signUpStudent(registrationData);

        // then
        verify(studentMapper).convertToEntity(registrationData);
        verify(studentRepository).save(studentDef);
    }
}