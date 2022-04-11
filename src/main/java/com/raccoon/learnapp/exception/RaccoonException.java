package com.raccoon.learnapp.exception;

import lombok.Getter;

@Getter
public class RaccoonException extends RuntimeException {

    private final ResponseMessageErrorCode messageErrorCode;
    private final Object[] params;

    public RaccoonException(ResponseMessageErrorCode messageCode, Object... params) {
        super();
        this.messageErrorCode = messageCode;
        this.params = params;
    }
}
