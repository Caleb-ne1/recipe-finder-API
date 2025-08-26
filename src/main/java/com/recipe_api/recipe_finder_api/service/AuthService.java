package com.recipe_api.recipe_finder_api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.recipe_api.recipe_finder_api.Exceptions.AlreadyFoundException;
import com.recipe_api.recipe_finder_api.Exceptions.NotFoundException;
import com.recipe_api.recipe_finder_api.Exceptions.RequiredException;
import com.recipe_api.recipe_finder_api.model.User;
import com.recipe_api.recipe_finder_api.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // create user account
    public User createAccount(User user) {

        if(user.getEmail().isEmpty() || user.getEmail().isBlank()) {
            throw new RequiredException("Email required");
        }

        if(user.getPassword().isEmpty()) {
            throw new RequiredException("Password required");
        }
        
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new AlreadyFoundException("Email already exists");
        }


        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);

    }

    // validate users
    public User validateUser(String email, String password) {
    
        return userRepository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPassword())) 
                .orElse(null);
    }

    // get user by id
    public User getUserById(Long userId) {
        return userRepository.findByUserID(userId)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));
    }
    
}
