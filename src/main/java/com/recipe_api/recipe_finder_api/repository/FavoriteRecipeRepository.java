package com.recipe_api.recipe_finder_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe_api.recipe_finder_api.model.FavoriteRecipe;
import java.util.List;
import java.util.Optional;

public interface FavoriteRecipeRepository extends JpaRepository<FavoriteRecipe, Long> {
    List<FavoriteRecipe> findByUserUserID(Long userID);
    Optional<FavoriteRecipe> findByUser_UserIDAndMealId(Long userId, String mealId);
    boolean existsByUserUserIDAndMealId(Long userID, String mealId);
}
