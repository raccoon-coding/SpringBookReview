package com.example.jpa.book.model;

import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class BookDto {
    @Getter
    @Builder
    public static class BookRes {
        private Integer id;
        private String title;
        private Integer pages;
        private Integer price;
        private List<Review> reviews;

        public static BookRes from(Book entity) {
            BookRes dto = BookRes.builder()
                    .id(entity.getId())
                    .title(entity.getTitle())
                    .pages(entity.getPages())
                    .price(entity.getPrice())
                    .reviews(entity.getReviews().stream().map(BookDto.BookRes::from).toList())
                    .build();


            return dto;
        }
    }

    @Getter
    public static class Register {
        private String title;
        private Integer pages;
        private Integer price;

        public Book toEntity() {
            Book entity = Book.builder()
                    .title(title)
                    .pages(pages)
                    .price(price)
                    .build();
            return entity;
        }
    }
}
