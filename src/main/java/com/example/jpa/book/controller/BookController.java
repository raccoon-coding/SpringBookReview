package com.example.jpa.book.controller;

import com.example.jpa.book.model.Book;
import com.example.jpa.book.model.BookDto;
import com.example.jpa.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/register")
    public ResponseEntity<String> registerBook(@RequestBody BookDto.Register dto) {
        bookService.register(dto);

        return ResponseEntity.status(200).body("등록 완료");
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookDto.BookRes>> getAllBooks() {
        List<BookDto.BookRes> result = bookService.list();

        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/read")
    public ResponseEntity read(@RequestParam Integer id) {
        BookDto.BookRes result = bookService.read(id);

        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDto.BookRes>> search(@RequestParam String title) {
        List<BookDto.BookRes> result = bookService.search(title);

        return ResponseEntity.status(200).body(result);
    }
}
