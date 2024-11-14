package io.whitetern.myblog.exception;

import io.whitetern.myblog.constants.ErrorCode;

public class AuthException extends RuntimeException {

    public ErrorCode errorCode;

    public AuthException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
