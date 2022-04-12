package com.raccoon.learnapp.student.impl.service;

import com.raccoon.learnapp.student.api.StudentDTO;
import com.raccoon.learnapp.student.impl.dao.entity.StudentEntity;
import com.raccoon.learnapp.student.impl.dao.StudentRepository;
import com.raccoon.learnapp.student.impl.exception.StudentDoesNotExistException;
import com.raccoon.learnapp.student.impl.model.Student;
import com.raccoon.learnapp.student.impl.service.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.raccoon.learnapp.student.impl.StudentTestData.ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
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

    @Test
    void shouldGetStudentById() {
        // given
        when(studentRepository.findById(ID)).thenReturn(Optional.of(studentEntity));
        when(studentMapper.convertToDTO(studentEntity)).thenReturn(studentDTO);

        // when
        StudentDTO result = studentService.getStudent(ID);

        // then
        assertThat(result).isEqualTo(studentDTO);
        verify(studentRepository).findById(ID);
        verify(studentMapper).convertToDTO(studentEntity);
    }

    @Test
    void shouldGetExceptionIfStudentDoesNotExistById() {
        when(studentRepository.findById(ID)).thenReturn(Optional.empty());
        assertThrows(StudentDoesNotExistException.class, () -> studentService.getStudent(ID));
        verifyNoInteractions(studentMapper);
    }
}