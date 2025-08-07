package com.example.jpa.review.service;

import com.example.jpa.review.dto.request.ReviewCreateDto;
import com.example.jpa.review.dto.response.ReviewDto;
import com.example.jpa.review.entity.Review;
import com.example.jpa.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final BookRepository bookRepository;
    private final ReviewRepository reviewRepository;

    public void saveReview(ReviewCreateDto dto) {
        Book book = bookRepository.findById(dto.bookId());
        reviewRepository.save(dto.toEntity(book));
    }

    public ReviewDto readOneReview(int id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isEmpty()) {
            throw new RuntimeException();
        }
        Review review = optionalReview.get();
        return ReviewDto.toDto(review);
    }

    public List<ReviewDto> readReviews(int bookId) {
        Book book = bookRepository.findById(bookId);
        List<Review> reviews = reviewRepository.findByBook(book);
        if(reviews.isEmpty()) {
            throw new RuntimeException();
        }
        return reviews.stream().map(ReviewDto::toDto).toList();
    }
}
