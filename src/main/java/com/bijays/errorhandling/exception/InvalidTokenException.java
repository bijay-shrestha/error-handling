package com.bijays.errorhandling.exception;

public class InvalidTokenException extends SecurityException {

    private static final long serialVersionUID = 5890299497591013820L;

    public InvalidTokenException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidTokenException(String msg) {
        super(msg);
    }
}
