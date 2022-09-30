package com.learn.springdata.converter;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "apple_survey")
public class SurveyPerson {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Convert(converter = LikeConverter.class)
    @Column(name = "like_apple")
    private boolean likeApple;
}
