package com.example.resttesttask2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException() {
        ErrorResponse response = new ErrorResponse("Student not found", new Date());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentValidationException.class)
    public ResponseEntity<ErrorResponse> handleStudentValidationException(Exception ex) {
        ErrorResponse response = new ErrorResponse(ex.getMessage(), new Date());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
