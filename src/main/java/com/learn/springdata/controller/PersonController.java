package com.learn.springdata.controller;

import com.learn.springdata.model.Person;
import com.learn.springdata.repo.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository repository) {
        this.personRepository = repository;
    }

    @PostMapping()
    public Person create(@RequestBody Person person) {
        return personRepository.save(person);
    }


    @GetMapping("/list")
    public List<Person> list() {
        return StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .toList();
    }

}
