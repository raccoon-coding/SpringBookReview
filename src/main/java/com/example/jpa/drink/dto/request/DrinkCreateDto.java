package com.example.jpa.drink.dto.request;

import com.example.jpa.drink.entity.Drink;
import com.example.jpa.ingredient.model.Ingredient;
import com.example.jpa.ingredient.model.IngredientDto;

import java.util.List;

public record DrinkCreateDto(String name, Integer price, String company, List<IngredientDto.Register> ingredients) {
    public Drink toDrinkEntity() {
        return Drink.builder()
                .name(name)
                .price(price)
                .company(company)
                .build();
    }

    public List<Ingredient> toIngredientsEntity(Drink drink) {
        return ingredients.stream().map(ingredientCreateDto -> ingredientCreateDto.toEntity(drink)).toList();
    }
}
