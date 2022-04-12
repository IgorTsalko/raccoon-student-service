package com.raccoon.learnapp.student.impl.service;

import com.raccoon.learnapp.student.api.StudentDTO;
import com.raccoon.learnapp.student.impl.dao.entity.StudentEntity;
import com.raccoon.learnapp.student.impl.dao.StudentRepository;
import com.raccoon.learnapp.student.impl.model.Student;
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

    @Mock
    private Student student;

    @Mock
    private StudentEntity studentEntity;

    @Mock
    private StudentDTO studentDTO;

    @Test
    void shouldReturnStudents() {
        // given
        when(studentRepository.findAll()).thenReturn(List.of(studentEntity));
        when(studentMapper.convertToDTO(studentEntity)).thenReturn(studentDTO);

        // when
        List<StudentDTO> result = studentService.getStudents();

        // then
        assertThat(result).asList().containsExactly(studentDTO);
        verify(studentRepository).findAll();
        verify(studentMapper).convertToDTO(studentEntity);
    }

    @Test
    void shouldSaveStudent() {
        // given
        when(studentMapper.convertToEntity(student)).thenReturn(studentEntity);

        // when
        studentService.saveStudent(student);

        // then
        verify(studentMapper).convertToEntity(student);
        verify(studentRepository).save(studentEntity);
    }
}