package com.bijays.errorhandling.exception;

public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = 5590299497591013820L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(final String message) {
        super(message);
    }
}