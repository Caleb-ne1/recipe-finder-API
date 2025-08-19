package com.recipe_api.recipe_finder_api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.recipe_api.recipe_finder_api.util.ErrorResponse;

@ControllerAdvice
public class GlobalHandler {
    
    @ExceptionHandler(value = {AlreadyFoundException.class})
    public ResponseEntity<ErrorResponse> handleAlreadyExists(AlreadyFoundException ex) {

        ErrorResponse alreadyFound = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage()
        ); 

        return new ResponseEntity<>(alreadyFound, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {RequiredException.class})
    public ResponseEntity<ErrorResponse> handleRequiredException(RequiredException ex) {

        ErrorResponse required = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage()
        );

        return new ResponseEntity<ErrorResponse>(required, HttpStatus.BAD_REQUEST);
    }
}
