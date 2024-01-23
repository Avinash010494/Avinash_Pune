package com.mahindrafinance.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;

public class AdvisorExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<String> handleCustomException(IllegalArgumentException ex){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String exceptionDetails = ex.getCause().toString();
        return new ResponseEntity<>(exceptionDetails,status);
    }

    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<String> handleCustomException(AuthenticationException ex){
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        String exceptionDetails = "USER NOT AUTHORIZED";
        return new ResponseEntity<>(exceptionDetails,status);
    }


}
