package com.recipe_api.recipe_finder_api.Exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionClass {
    private String message;
    private Throwable cause;
    private HttpStatus httpStatus;

    public ExceptionClass(String message, Throwable cause, HttpStatus httpStatus) {
        this.message = message;
        this.cause = cause;
        this.httpStatus = httpStatus;
    }

    //getters
    public String getMessage() { return message; }
    public Throwable getCause() { return cause; }
    public HttpStatus getHttpStatus() { return httpStatus; }
}
