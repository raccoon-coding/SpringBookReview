package com.example.jpa.book.service;

import com.example.jpa.book.model.Book;
import com.example.jpa.book.model.BookDto;
import com.example.jpa.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void register(BookDto.Register bookDto) {
        bookRepository.save(bookDto.toEntity());
    }

    public List<BookDto.BookRes> list() {
        List<Book> result = bookRepository.findAll();

        return result.stream().map(BookDto.BookRes::from).toList();
    }

    public BookDto.BookRes read(Integer id) {
        Optional<Book> result = bookRepository.findById(id);

        if (result.isPresent()) {
            Book entity = result.get();

            return BookDto.BookRes.from(entity);
        }

        return null;
    }

    public List<BookDto.BookRes> search(String title) {
        List<Book> result = bookRepository.findByTitle(title);

        return result.stream().map(BookDto.BookRes::from).toList();
    }
}
