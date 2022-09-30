package com.learn.springdata.converter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyPersonRepository extends JpaRepository<SurveyPerson, Long> {
}
