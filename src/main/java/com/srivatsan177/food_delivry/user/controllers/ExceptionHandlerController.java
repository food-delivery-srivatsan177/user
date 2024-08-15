package com.srivatsan177.food_delivry.user.controllers;

import com.srivatsan177.food_delivry.user.dtos.ExceptionDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> badRequest(BadRequestException ex) {
        return new ResponseEntity<>(new ExceptionDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
