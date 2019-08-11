package com.bijays.errorhandling.exception;

import lombok.Getter;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;

/**
 * <p>OperationUnSuccessfulException class.</p>
 *
 * @author bijayshrestha
 * @version $Id: $Id
 */

@Getter
public class OperationUnSuccessfulException extends RuntimeException {

    private ExceptionResponse exception;

    public OperationUnSuccessfulException(Class clazz, String debugMessage){
        super(debugMessage);
        exception = ExceptionResponse.builder()
                .errorMessage(generateMessage(clazz))
                .debugMessage(debugMessage)
                .status(EXPECTATION_FAILED)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    private String generateMessage(Class clazz){
        return clazz.getSimpleName() + " invalid input.";
    }
}
