package com.george.apirankguesser.exception;

import jakarta.validation.ConstraintViolationException;
import org.hibernate.query.PathException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<CustomExceptionDTO> handleBusinessException(BusinessException e) {
        return ResponseEntity.status(e.getStatus()).body(new CustomExceptionDTO(
                e.getStatus().value(),
                e.getMessage()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomExceptionDTO> handleException(Exception e) {
        return ResponseEntity.status(500).body(new CustomExceptionDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error"
        ));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<CustomExceptionDTO> handleNoHandlerFoundException(NoHandlerFoundException e) {
        return ResponseEntity.status(404).body(new CustomExceptionDTO(
                HttpStatus.NOT_FOUND.value(),
                "Resource Not Found"
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomExceptionDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(400).body(new CustomExceptionDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request"
        ));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomExceptionDTO> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.status(400).body(new CustomExceptionDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request"
        ));
    }
}
