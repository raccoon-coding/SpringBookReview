package com.example.jpa.drink.dto.response;

import com.example.jpa.drink.entity.Drink;
import com.example.jpa.ingredient.model.IngredientDto;

import java.util.List;

public record DrinkDto(Integer id, String name, Integer price, String company, List<IngredientDto.IngredientRes> ingredients) {
    public static DrinkDto toDto(Drink drink) {
        return new DrinkDto(drink.getId(), drink.getName(), drink.getPrice(), drink.getCompany(),
                drink.getIngredients().stream().map(IngredientDto.IngredientRes::from).toList());
    }
}
