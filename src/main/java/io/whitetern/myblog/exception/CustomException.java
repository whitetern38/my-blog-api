package io.whitetern.myblog.exception;

import io.whitetern.myblog.constants.ErrorCode;

public class CustomException extends RuntimeException {

    private ErrorCode errorCode;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
