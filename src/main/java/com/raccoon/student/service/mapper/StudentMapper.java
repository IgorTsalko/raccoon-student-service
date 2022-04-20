package com.raccoon.student.service.mapper;

import com.raccoon.student.dao.entity.StudentEntity;
import com.raccoon.student.model.NewStudentDTO;
import com.raccoon.student.model.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO convertToDTO(StudentEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "level", ignore = true)
    StudentEntity convertToEntity(NewStudentDTO student);
}
