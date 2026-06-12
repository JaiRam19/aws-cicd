package com.jayram.tech.post_image.exception;

import com.jayram.tech.post_image.util.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorDetails errorDetails = (new ErrorDetails(ex.getMessage(), HttpStatus.NOT_FOUND));
        return ResponseEntity.status(errorDetails.getHttpStatus()).body(errorDetails);
    }
}
