package com.example.jpa.ingredient.repository;

import com.example.jpa.ingredient.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
