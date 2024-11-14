package io.whitetern.myblog.exception;

import io.whitetern.myblog.constants.ErrorCode;

public class UserException extends RuntimeException {

    public ErrorCode errorCode;

    public UserException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
