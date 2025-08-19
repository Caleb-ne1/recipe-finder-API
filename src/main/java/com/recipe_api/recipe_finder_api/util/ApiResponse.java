package com.recipe_api.recipe_finder_api.util;


public class ApiResponse<T> {
    private String message;
    private T data;

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    //getter
    public String getMessage() { return message; }
    public T getData() { return data; }
    
}
