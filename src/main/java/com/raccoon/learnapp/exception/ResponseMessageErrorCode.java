package com.raccoon.learnapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseMessageErrorCode {

    STUDENT_DOES_NOT_EXIST_BY_ID(1000);

    private final HttpStatus httpStatus;
    private final int code;

    ResponseMessageErrorCode(int code) {
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.code = code;
    }

    ResponseMessageErrorCode(HttpStatus httpStatus, int code) {
        this.httpStatus = httpStatus;
        this.code = code;
    }
}
