package com.learn.springdata.controller;

import com.learn.springdata.model.Book;
import com.learn.springdata.model.Publisher;
import com.learn.springdata.repo.BookRepository;
import com.learn.springdata.repo.PublisherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @PostMapping()
    public Publisher create(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }


    @GetMapping("/list")
    public List<Publisher> list() {
        return StreamSupport.stream(publisherRepository.findAll().spliterator(), false)
                .toList();
    }


}
