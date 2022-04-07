package com.raccoon.learnapp.student.impl.service;

import com.raccoon.learnapp.student.api.StudentDTO;
import com.raccoon.learnapp.student.impl.dao.entity.StudentEntity;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;
import org.springframework.stereotype.Component;

@Component
public class StudentConvertor {

    public StudentDTO convertToDTO(StudentEntity entity) {
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setLogin(entity.getLogin());
        dto.setEmail(entity.getEmail());
        dto.setLevel(entity.getLevel());
        return dto;
    }

    public StudentEntity convertToEntity(StudentRegistrationData data) {
        StudentEntity entity = new StudentEntity();
        entity.setFirstName(data.getFirstName());
        entity.setLastName(data.getLastName());
        entity.setLogin(data.getLogin());
        entity.setEmail(data.getEmail());
        entity.setPassword(data.getPassword());
        return entity;
    }
}
