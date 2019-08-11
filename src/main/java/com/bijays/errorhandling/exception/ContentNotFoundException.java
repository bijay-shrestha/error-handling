package com.bijays.errorhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ContentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5990299497591013821L;

    public ContentNotFoundException(final String message) {
        super(message);
    }

}