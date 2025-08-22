package com.recipe_api.recipe_finder_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe_api.recipe_finder_api.model.FavoriteRecipe;
import java.util.List;

public interface FavoriteRecipeRepository extends JpaRepository<FavoriteRecipe, Long> {
    List<FavoriteRecipe> findByUserUserID(Long userID);
    boolean existsByUserUserIDAndMealId(Long userID, String mealId);
}
