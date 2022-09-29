package com.learn.springdata.repo.survey;

import com.learn.springdata.model.survey.SurveyPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyPersonRepository extends JpaRepository<SurveyPerson, Long> {
}
