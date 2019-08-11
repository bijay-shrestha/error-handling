package com.bijays.errorhandling.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
class ContentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5990299497591013821L;

    ContentNotFoundException(final String message) {
        super(message);
    }

}