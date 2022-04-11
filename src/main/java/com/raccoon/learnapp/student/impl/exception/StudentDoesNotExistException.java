package com.raccoon.learnapp.student.impl.exception;

import com.raccoon.learnapp.exception.RaccoonException;
import com.raccoon.learnapp.exception.ResponseMessageErrorCode;

public class StudentDoesNotExistException extends RaccoonException {

    public StudentDoesNotExistException(Long id) {
        super(ResponseMessageErrorCode.STUDENT_DOES_NOT_EXIST_BY_ID, id);
    }
}
