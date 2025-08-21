package com.recipe_api.recipe_finder_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class RecipeFinderService {

    private final RestTemplate restTemplate;

    public RecipeFinderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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

    
}
