package com.raccoon.learnapp.student.impl.service;

import com.raccoon.learnapp.student.api.Student;
import com.raccoon.learnapp.student.impl.dao.StudentDefinition;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static com.raccoon.learnapp.student.impl.StudentTestData.EMAIL;
import static com.raccoon.learnapp.student.impl.StudentTestData.FIRST_NAME;
import static com.raccoon.learnapp.student.impl.StudentTestData.ID;
import static com.raccoon.learnapp.student.impl.StudentTestData.LAST_NAME;
import static com.raccoon.learnapp.student.impl.StudentTestData.LEVEL;
import static com.raccoon.learnapp.student.impl.StudentTestData.LOGIN;
import static com.raccoon.learnapp.student.impl.StudentTestData.PASSWORD;
import static com.raccoon.learnapp.student.impl.StudentTestData.generateRegistrationData;
import static com.raccoon.learnapp.student.impl.StudentTestData.generateStudentDef;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {MockitoExtension.class})
class StudentConvertorTest {

    private StudentConvertor studentConvertor;

    @BeforeEach
    void setUp() {
        studentConvertor = new StudentConvertor();
    }

    @Test
    void shouldConvertDefinitionToModel() {
        // given
        StudentDefinition definition = generateStudentDef();

        // when
        Student result = studentConvertor.convert(definition);

        // then
        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(result.getLastName()).isEqualTo(LAST_NAME);
        assertThat(result.getLogin()).isEqualTo(LOGIN);
        assertThat(result.getEmail()).isEqualTo(EMAIL);
        assertThat(result.getLevel()).isEqualTo(LEVEL);
    }

    @Test
    void shouldConvertRegistrationDataToDefinition() {
        // given
        StudentRegistrationData data = generateRegistrationData();

        // when
        StudentDefinition result = studentConvertor.convert(data);

        // then
        assertThat(result.getId()).isNull();
        assertThat(result.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(result.getLastName()).isEqualTo(LAST_NAME);
        assertThat(result.getLogin()).isEqualTo(LOGIN);
        assertThat(result.getEmail()).isEqualTo(EMAIL);
        assertThat(result.getPassword()).isEqualTo(PASSWORD);
        assertThat(result.getLevel()).isNull();
    }
}