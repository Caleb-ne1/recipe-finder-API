package com.recipe_api.recipe_finder_api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recipe_api.recipe_finder_api.model.FavoriteRecipe;
import com.recipe_api.recipe_finder_api.service.FavoritesService;

@Controller
@RequestMapping("/favorites")
public class FavoritesController {

    private FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }
    
     // Add to favorites
    @PostMapping("/add")
    public ResponseEntity<?> addToFavorites(@RequestParam Long userId, @RequestParam String mealId) {
        FavoriteRecipe response = favoritesService.addToFavorites(userId, mealId);

        return ResponseEntity.ok(response);
    }

    // delete recipe
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRecipe(@RequestParam Long userId, @RequestParam String mealId) {
        FavoriteRecipe deleted = favoritesService.deleteRecipe(userId, mealId);
        return ResponseEntity.ok(deleted);
    }

}
