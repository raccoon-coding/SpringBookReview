package com.example.jpa.review.dto.response;

import com.example.jpa.review.entity.Review;

public record ReviewDto(int id, String contents, Integer score) {
    public static ReviewDto toDto(Review review) {
        return new ReviewDto(review.getId(), review.getContents(), review.getScore());
    }
}
