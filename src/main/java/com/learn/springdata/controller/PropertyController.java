package com.learn.springdata.controller;

import com.learn.springdata.model.Property;
import com.learn.springdata.repo.PersonRepository;
import com.learn.springdata.repo.PropertyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyRepository propertyRepository;
    private final PersonRepository personRepository;
    public PropertyController(PropertyRepository propertyRepository, PersonRepository personRepository) {
        this.propertyRepository = propertyRepository;
        this.personRepository = personRepository;
    }

    @PostMapping("/{personId}")
    public Property create(@PathVariable long personId, @RequestBody Property property) {
        var person = personRepository.getOne(personId);

        property.setPerson(person);
        return propertyRepository.save(property);
    }


    @GetMapping("/list")
    public List<Property> list() {
        return StreamSupport.stream(propertyRepository.findAll().spliterator(), false)
                .toList();
    }


}
