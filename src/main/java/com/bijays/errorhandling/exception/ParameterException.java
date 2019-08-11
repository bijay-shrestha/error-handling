package com.bijays.errorhandling.exception;

public class ParameterException extends RuntimeException {

    private static final long serialVersionUID = 5490299497591013820L;

    public ParameterException(String msg) {
        super(msg);
    }
}