package com.recipe_api.recipe_finder_api.Exceptions;

public class RequiredException extends RuntimeException {
    public RequiredException(String message) {
        super(message);
    }

    public RequiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
