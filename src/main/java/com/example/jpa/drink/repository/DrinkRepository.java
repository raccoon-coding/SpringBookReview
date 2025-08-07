package com.example.jpa.drink.repository;

import com.example.jpa.drink.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
    Optional<Drink> findByName(String name);
}
