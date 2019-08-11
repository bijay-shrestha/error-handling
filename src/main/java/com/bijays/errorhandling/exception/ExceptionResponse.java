package com.bijays.errorhandling.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * <p>ExceptionResponse class.</p>
 *
 * @author bijayshrestha
 * @version $Id: $Id
 */


@Getter
@Builder
class ExceptionResponse {
    private final HttpStatus status;
    private final String errorMessage;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timeStamp;
    private final String debugMessage;
}
