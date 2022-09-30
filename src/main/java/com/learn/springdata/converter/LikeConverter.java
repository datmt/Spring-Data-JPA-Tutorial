package com.learn.springdata.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class LikeConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        return aBoolean ? "LIKE" : "DONOT";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        return s != null && s.equalsIgnoreCase("LIKE");
    }
}
