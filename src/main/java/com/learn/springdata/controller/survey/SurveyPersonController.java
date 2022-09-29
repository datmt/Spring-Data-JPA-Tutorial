package com.learn.springdata.controller.survey;

import com.learn.springdata.model.survey.SurveyPerson;
import com.learn.springdata.repo.survey.SurveyPersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/surveys")
public class SurveyPersonController {

    private final SurveyPersonRepository repository;

    public SurveyPersonController(SurveyPersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public SurveyPerson save(@RequestBody SurveyPerson person) {
        return repository.save(person);
    }

    @GetMapping("/list")
    public List<SurveyPerson> getAll() {
        return repository.findAll();
    }
}
