package com.raccoon.student.impl.service;

import com.raccoon.student.model.NewStudentDTO;
import com.raccoon.student.model.StudentDTO;
import com.raccoon.student.dao.entity.StudentEntity;
import com.raccoon.student.dao.StudentRepository;
import com.raccoon.student.exception.StudentDoesNotExistException;
import com.raccoon.student.service.StudentServiceImpl;
import com.raccoon.student.service.mapper.StudentMapper;
import com.raccoon.student.impl.StudentTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

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
    private NewStudentDTO newStudentDTO;

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
        when(studentMapper.convertToEntity(newStudentDTO)).thenReturn(studentEntity);

        // when
        studentService.saveStudent(newStudentDTO);

        // then
        verify(studentMapper).convertToEntity(newStudentDTO);
        verify(studentRepository).save(studentEntity);
    }

    @Test
    void shouldGetStudentById() {
        // given
        when(studentRepository.findById(StudentTestData.ID)).thenReturn(Optional.of(studentEntity));
        when(studentMapper.convertToDTO(studentEntity)).thenReturn(studentDTO);

        // when
        StudentDTO result = studentService.getStudent(StudentTestData.ID);

        // then
        assertThat(result).isEqualTo(studentDTO);
        verify(studentRepository).findById(StudentTestData.ID);
        verify(studentMapper).convertToDTO(studentEntity);
    }

    @Test
    void shouldGetExceptionIfStudentDoesNotExistById() {
        when(studentRepository.findById(StudentTestData.ID)).thenReturn(Optional.empty());
        assertThrows(StudentDoesNotExistException.class, () -> studentService.getStudent(StudentTestData.ID));
        verifyNoInteractions(studentMapper);
    }
}