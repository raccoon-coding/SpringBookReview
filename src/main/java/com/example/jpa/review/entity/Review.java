package com.example.jpa.review.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer score;
    private String contents;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
