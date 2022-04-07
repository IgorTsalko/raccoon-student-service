package com.raccoon.learnapp.student.impl.service.mapper;

import com.raccoon.learnapp.student.api.StudentDTO;
import com.raccoon.learnapp.student.impl.dao.entity.StudentEntity;
import com.raccoon.learnapp.student.impl.model.StudentRegistrationData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO convertToDTO(StudentEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "level", ignore = true)
    StudentEntity convertToEntity(StudentRegistrationData data);
}
