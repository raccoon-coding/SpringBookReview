package com.example.jpa.review.dto.request;

import com.example.jpa.book.model.Book;
import com.example.jpa.review.entity.Review;

public record ReviewCreateDto(String contents, Integer score, Integer bookId) {
    public Review toEntity(Book book) {
        return Review.builder()
                .book(book)
                .score(score)
                .contents(contents)
                .build();
    }
}
