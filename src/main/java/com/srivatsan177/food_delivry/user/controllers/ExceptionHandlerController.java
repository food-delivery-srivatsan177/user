package com.srivatsan177.food_delivry.user.controllers;

import com.srivatsan177.food_delivry.user.dtos.ExceptionDTO;
import com.srivatsan177.food_delivry.user.dtos.ValidationErrorDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> badRequest(BadRequestException ex) {
        return new ResponseEntity<>(new ExceptionDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDTO> badRequest(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        return new ResponseEntity<>(new ValidationErrorDTO("Validation failed", errors), HttpStatus.BAD_REQUEST);
    }
}
