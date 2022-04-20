package com.raccoon.student.exception;

import com.raccoon.common.exception.ErrorMessageCode;
import com.raccoon.common.exception.RaccoonException;

public class StudentDoesNotExistException extends RaccoonException {

    public StudentDoesNotExistException(Long id) {
        super(ErrorMessageCode.STUDENT_DOES_NOT_EXIST_BY_ID, id);
    }
}
