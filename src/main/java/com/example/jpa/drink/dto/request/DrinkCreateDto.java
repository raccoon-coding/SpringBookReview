package com.example.jpa.drink.dto.request;

import com.example.jpa.drink.entity.Drink;

public record DrinkCreateDto(String name, Integer price, String company, List<IngredientCreateDto> ingredients) {
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
