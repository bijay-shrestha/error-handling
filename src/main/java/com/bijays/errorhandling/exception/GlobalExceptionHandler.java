package com.bijays.errorhandling.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException ex){
        log.error("-------- DATA NOT FOUND EXCEPTION ------");
        return buildResponseEntity(ex.getException());
    }

    @ExceptionHandler(value = {OperationUnSuccessfulException.class})
    public ResponseEntity<Object> handleOperationUnsuccessfulException(OperationUnSuccessfulException ex){
        log.error("------- OPERATION UNSUCCESSFUL EXCEPTION -------");
        return buildResponseEntity(ex.getException());
    }

    @ExceptionHandler(value = {OrderServiceException.class})
    public ResponseEntity<Object> handleOrderServiceException(OrderServiceException ex){
        log.error("------- ORDER SERVICE EXCEPTION -------");
        return buildResponseEntity(ex.getException());
    }

    private ResponseEntity<Object> buildResponseEntity(ExceptionResponse e) {
        return new ResponseEntity<>(e, e.getStatus());
    }
}
