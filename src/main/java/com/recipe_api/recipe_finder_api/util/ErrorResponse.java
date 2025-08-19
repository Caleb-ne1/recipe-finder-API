package com.recipe_api.recipe_finder_api.util;

public class ErrorResponse {
    private int status;
    private String message;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // getters
    public int getStatus() { return status; }
    public String getMessage() { return message; }
}
