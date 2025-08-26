package com.recipe_api.recipe_finder_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "favorite_recipes")
public class FavoriteRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mealId; 

    // Relationship with user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public FavoriteRecipe() {}

    public FavoriteRecipe(String mealId, User user) {
        this.mealId = mealId;
        this.user = user;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getMealId() { return mealId; }
    public void setMealId(String mealId) {this.mealId = mealId; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

}
