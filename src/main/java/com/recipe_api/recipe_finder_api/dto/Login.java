package com.recipe_api.recipe_finder_api.dto;

public class Login {
    private String email;
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //getters
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
