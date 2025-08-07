package com.example.jpa.drink.service;

import com.example.jpa.drink.dto.request.DrinkCreateDto;
import com.example.jpa.drink.dto.response.DrinkDto;
import com.example.jpa.drink.entity.Drink;
import com.example.jpa.drink.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DrinkService {
    private final IngredientRepository ingredientRepository;
    private final DrinkRepository drinkRepository;

    public void saveDrink(DrinkCreateDto dto) {
        Drink save = drinkRepository.save(dto.toDrinkEntity());
        ingredientRepository.saveAll(dto.toIngredientsEntity(save));
    }

    public DrinkDto readOneDrink(int id) {
        Optional<Drink> optionalDrink = drinkRepository.findById(id);
        if(optionalDrink.isEmpty()) {
            throw new RuntimeException();
        }
        return DrinkDto.toDto(optionalDrink.get());
    }

    public List<DrinkDto> readDrinks() {
        List<Drink> all = drinkRepository.findAll();
        if(all.isEmpty()) {
            throw new RuntimeException();
        }
        return all.stream().map(DrinkDto::toDto).toList();
    }

    public DrinkDto searchDrink(String name) {
        Optional<Drink> optionalDrink = drinkRepository.findByName(name);
        if(optionalDrink.isEmpty()) {
            throw new RuntimeException();
        }
        return DrinkDto.toDto(optionalDrink.get());
    }
}
