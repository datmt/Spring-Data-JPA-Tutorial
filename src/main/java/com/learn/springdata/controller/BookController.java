package com.learn.springdata.controller;

import com.learn.springdata.model.Book;
import com.learn.springdata.repo.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping()
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }


    @GetMapping("/list")
    public List<Book> list() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .toList();
    }


}
