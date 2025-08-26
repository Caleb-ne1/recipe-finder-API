package com.recipe_api.recipe_finder_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe_api.recipe_finder_api.Exceptions.AlreadyFoundException;
import com.recipe_api.recipe_finder_api.Exceptions.NotFoundException;
import com.recipe_api.recipe_finder_api.Exceptions.RequiredException;
import com.recipe_api.recipe_finder_api.model.FavoriteRecipe;
import com.recipe_api.recipe_finder_api.model.User;
import com.recipe_api.recipe_finder_api.repository.FavoriteRecipeRepository;
import com.recipe_api.recipe_finder_api.repository.UserRepository;

@Service
public class FavoritesService {

    @Autowired
    private FavoriteRecipeRepository favoriteRecipeRepository;

    @Autowired
    private UserRepository userRepository;

    public FavoritesService(FavoriteRecipeRepository favoriteRecipeRepository, UserRepository userRepository){
        this.favoriteRecipeRepository = favoriteRecipeRepository;
        this.userRepository = userRepository;
    }

    // add meals to favorites by user id & meal id
    public FavoriteRecipe addToFavorites(Long userId, String mealId) {
        // check fields
        if(mealId == null || mealId.isEmpty() ) {
            throw new RequiredException("MealId required");
        }

        User user = userRepository.findByUserID(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        // Prevent duplicates
        if (favoriteRecipeRepository.existsByUserUserIDAndMealId(userId, mealId)) {
            throw new AlreadyFoundException("Recipe already in favorites");
        }

        FavoriteRecipe favoriteRecipe = new FavoriteRecipe();
        favoriteRecipe.setMealId(mealId);
        favoriteRecipe.setUser(user);
        return favoriteRecipeRepository.save(favoriteRecipe);
    }

    // delete recipe user id & recipe id
    public FavoriteRecipe deleteRecipe(Long userId, String mealId) {
        FavoriteRecipe favorite = favoriteRecipeRepository.findByUser_UserIDAndMealId(userId, mealId)
                .orElseThrow(() -> new NotFoundException("Favorite recipe not found"));

        favoriteRecipeRepository.delete(favorite);

        return favorite;
    }

}
