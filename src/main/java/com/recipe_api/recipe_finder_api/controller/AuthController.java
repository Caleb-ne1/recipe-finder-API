package com.recipe_api.recipe_finder_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recipe_api.recipe_finder_api.model.User;
import com.recipe_api.recipe_finder_api.service.AuthService;
import com.recipe_api.recipe_finder_api.util.ApiResponse;

@Controller
@RequestMapping("user")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<User>> createAccount(@RequestBody User user) {
        User createReq = authService.createAccount(user);

        ApiResponse<User> response = new ApiResponse<User>("User account created successfully", createReq);

        return new ResponseEntity<ApiResponse<User>>(response, HttpStatus.CREATED);

    }
}
