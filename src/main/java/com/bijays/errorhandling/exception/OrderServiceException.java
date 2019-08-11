package com.bijays.errorhandling.exception;

import lombok.Getter;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;

/**
 * <p>OrderServiceException class.</p>
 *
 * @author bijayshrestha
 * @version $Id: $Id
 */

@Getter
public class OrderServiceException extends RuntimeException {

    private ExceptionResponse exception;

    public OrderServiceException(Class clazz, String debugMessage){
        super(debugMessage);
        exception = ExceptionResponse.builder()
                .errorMessage(generateMessage(clazz))
                .debugMessage(debugMessage)
                .status(BAD_GATEWAY)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    private String generateMessage(Class clazz){
        return clazz.getSimpleName() + " service exception.";
    }

}
