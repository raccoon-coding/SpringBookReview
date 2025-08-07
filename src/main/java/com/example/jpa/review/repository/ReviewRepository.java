package com.example.jpa.review.repository;

import com.example.jpa.book.model.Book;
import com.example.jpa.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByBook(Book book);
}
