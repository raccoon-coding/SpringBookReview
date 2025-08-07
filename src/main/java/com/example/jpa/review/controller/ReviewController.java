package com.example.jpa.review.controller;

import com.example.jpa.review.dto.request.ReviewCreateDto;
import com.example.jpa.review.dto.response.ReviewDto;
import com.example.jpa.review.entity.Review;
import com.example.jpa.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/list")
    public ResponseEntity<List<ReviewDto>> getReviews(int bookId) {
        List<ReviewDto> reviews = reviewService.readReviews(bookId);
        return ResponseEntity.status(200).body(reviews);
    }

    @GetMapping("/read")
    public ResponseEntity<ReviewDto> readReview(int reviewId) {
        ReviewDto review = reviewService.readOneReview(reviewId);
        return ResponseEntity.status(200).body(review);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReview(ReviewCreateDto dto) {
        reviewService.saveReview(dto);
        return ResponseEntity.status(200).body("등록 성공");
    }
}
