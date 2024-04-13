package com.api.TestHub.controller;

import com.api.TestHub.exception.BadRequestException;
import com.api.TestHub.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundException> notFoundExceptionHandling(NotFoundException e) {
        logger.error("Exception occurred: {}", e.getMessage(), e);
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestException> badRequestExceptionHandling(BadRequestException e) {
        logger.error("Exception occurred: {}", e.getMessage(), e);
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}