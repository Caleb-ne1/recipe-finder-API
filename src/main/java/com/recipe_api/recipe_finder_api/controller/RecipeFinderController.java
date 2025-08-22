package com.recipe_api.recipe_finder_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.recipe_api.recipe_finder_api.service.RecipeFinderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/meals")
public class RecipeFinderController {
    
    private RecipeFinderService recipeFinderService;

    public RecipeFinderController(RecipeFinderService recipeFinderService) {
        this.recipeFinderService = recipeFinderService;
    }

    // List all Categories
    @GetMapping("/list_all_categories")
    public ResponseEntity<JsonNode> ListAllCategories() {
        JsonNode response = recipeFinderService.ListCategories();
        return ResponseEntity.ok(response);
    }

    // Filter by Category
    @GetMapping("/search_category")
    public ResponseEntity<?> getMealsByCategory(@RequestParam String c) {
        JsonNode response = recipeFinderService.getMeals(c);
        return ResponseEntity.ok(response);
    }

    // Search meal by name
    @GetMapping("/search")
    public ResponseEntity<JsonNode> searchMeal(@RequestParam String name) {
        JsonNode response = recipeFinderService.searchMeal(name);
        return ResponseEntity.ok(response);
    }

    // Filter by main ingredient
    @GetMapping("/filter")
    public ResponseEntity<JsonNode> getByIngredient(@RequestParam String ingredient) {
        JsonNode response = recipeFinderService.getByIngredient(ingredient);
        return ResponseEntity.ok(response);
    }

    // Lookup full meal details by id
    @GetMapping("/lookup")
    public ResponseEntity<JsonNode> getMealDetailsById(@RequestParam String id) {
        JsonNode response = recipeFinderService.getMealDetailsById(id);
        return ResponseEntity.ok(response);
    }

    
}
