package com.example.jpa.drink.controller;

import com.example.jpa.drink.dto.request.DrinkCreateDto;
import com.example.jpa.drink.dto.response.DrinkDto;
import com.example.jpa.drink.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drink")
@RequiredArgsConstructor
public class DrinkController {
    private final DrinkService service;

    @GetMapping("/list")
    public ResponseEntity<List<DrinkDto>> readDrinks() {
        List<DrinkDto> drinks = service.readDrinks();
        return ResponseEntity.status(200).body(drinks);
    }

    @PostMapping("/read")
    public ResponseEntity<DrinkDto> readDrink(int id) {
        DrinkDto drink = service.readOneDrink(id);
        return ResponseEntity.status(200).body(drink);
    }

    @PostMapping("/search")
    public ResponseEntity<DrinkDto> readDrink(String name) {
        DrinkDto drink = service.searchDrink(name);
        return ResponseEntity.status(200).body(drink);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveDrink(DrinkCreateDto dto) {
        service.saveDrink(dto);
        return ResponseEntity.status(200).body("등록 완료");
    }
}
