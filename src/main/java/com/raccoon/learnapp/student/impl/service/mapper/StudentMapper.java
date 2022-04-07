package com.raccoon.learnapp.student.impl.service.mapper;

import com.raccoon.learnapp.student.api.StudentDTO;
import com.raccoon.learnapp.student.impl.dao.entity.StudentEntity;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO convertToDTO(StudentEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "level", ignore = true)
    StudentEntity convertToEntity(StudentRegistrationData data);
}
