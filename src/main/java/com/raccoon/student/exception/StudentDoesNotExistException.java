package com.raccoon.student.exception;

public class StudentDoesNotExistException extends RaccoonException {

    public StudentDoesNotExistException(Long id) {
        super(ResponseMessageErrorCode.STUDENT_DOES_NOT_EXIST_BY_ID, id);
    }
}
