package com.recipe_api.recipe_finder_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.recipe_api.recipe_finder_api.Exceptions.AlreadyFoundException;
import com.recipe_api.recipe_finder_api.Exceptions.NotFoundException;
import com.recipe_api.recipe_finder_api.Exceptions.RequiredException;
import com.recipe_api.recipe_finder_api.model.FavoriteRecipe;
import com.recipe_api.recipe_finder_api.model.User;
import com.recipe_api.recipe_finder_api.repository.FavoriteRecipeRepository;
import com.recipe_api.recipe_finder_api.repository.UserRepository;

@Service
public class RecipeFinderService {

    private final RestTemplate restTemplate;
    private FavoriteRecipeRepository favoriteRecipeRepository;
    private UserRepository userRepository;

    public RecipeFinderService(RestTemplate restTemplate, FavoriteRecipeRepository favoriteRecipeRepository, UserRepository userRepository) {
        this.restTemplate = restTemplate;
        this.favoriteRecipeRepository = favoriteRecipeRepository;
        this.userRepository = userRepository;
    }


    // get meals by search word
    public JsonNode getMeals(String category) {
        String API_URL = "https://www.themealdb.com/api/json/v1/1/filter.php?c=" + category;
        return restTemplate.getForObject(API_URL, JsonNode.class);
    }

    // Search meal by name
    public JsonNode searchMeal(String mealName) {
        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + mealName;
        return restTemplate.getForObject(url, JsonNode.class);
    }

    // List all Categories
    public JsonNode ListCategories() {
        String API_URL = "https://www.themealdb.com/api/json/v1/1/list.php?c=list";
        return restTemplate.getForObject(API_URL, JsonNode.class);
    }

    // Filter by main ingredient
    public JsonNode getByIngredient(String ingredient) {
        String API_URL = "https://www.themealdb.com/api/json/v1/1/filter.php?i=" + ingredient;
        return restTemplate.getForObject(API_URL, JsonNode.class);
    }

    // Lookup full meal details by id
    public JsonNode getMealDetailsById(String mealId) {
        String API_URL = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + mealId;
        return restTemplate.getForObject(API_URL, JsonNode.class);
    }
 
}
