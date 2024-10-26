package io.whitetern.myblog.exception;

public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
}
