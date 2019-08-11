package com.bijays.errorhandling.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * <p>RestExceptionHandler class.</p>
 *
 * @author bijayshrestha
 * @version $Id: $Id
 */

@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException ex){
        log.error("-------- DATA NOT FOUND EXCEPTION ------");
        return buildResponseEntity(ex.getException());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleOperationUnsuccessfulException(OperationUnSuccessfulException ex){
        log.error("------- OPERATION UNSUCCESSFUL EXCEPTION -------");
        return buildResponseEntity(ex.getException());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleOrderServiceException(OrderServiceException ex){
        log.error("------- ORDER SERVICE EXCEPTION -------");
        return buildResponseEntity(ex.getException());
    }

    private ResponseEntity<Object> buildResponseEntity(ExceptionResponse e) {
        return new ResponseEntity<>(e, e.getStatus());
    }
}
