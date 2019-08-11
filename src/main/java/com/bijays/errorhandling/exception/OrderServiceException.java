package com.bijays.errorhandling.exception;

public class OrderServiceException extends Exception {
    private static final long serialVersionUID = 5970299497591013820L;

    public OrderServiceException() {
        super();
    }

    public OrderServiceException(final String message) {
        super(message);
    }

}
