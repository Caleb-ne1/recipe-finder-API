package com.recipe_api.recipe_finder_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe_api.recipe_finder_api.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findByUserID(Long userID);

    Optional<User> findByEmail(String email);
}
