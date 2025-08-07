package com.example.jpa.ingredient.model;

import com.example.jpa.drink.entity.Drink;
import lombok.Builder;
import lombok.Getter;

public class IngredientDto {
    @Getter
    @Builder
    public static class IngredientRes {
        private Integer id;
        private String name;
        private Integer gram;

        public static IngredientDto.IngredientRes from(Ingredient entity) {
            IngredientDto.IngredientRes dto = IngredientDto.IngredientRes.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .gram(entity.getGram())
                    .build();

            return dto;
        }
    }

    @Getter
    public static class Register {
        private String name;
        private Integer gram;

        public Ingredient toEntity(Drink drink) {
            Ingredient entity = Ingredient.builder()
                    .name(name)
                    .gram(gram)
                    .drink(drink)
                    .build();

            return entity;
        }
    }
}
