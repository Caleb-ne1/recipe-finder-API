package com.recipe_api.recipe_finder_api.Exceptions;

public class AlreadyFoundException extends RuntimeException {
    
    public AlreadyFoundException(String message) {
        super(message);
    }

    public AlreadyFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
