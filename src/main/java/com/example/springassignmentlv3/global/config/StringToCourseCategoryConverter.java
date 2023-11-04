package com.example.springassignmentlv3.global.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.springassignmentlv3.course.entity.CourseCategory;

@Component
public class StringToCourseCategoryConverter implements Converter<String, CourseCategory> {
    
    @Override
    public CourseCategory convert(String source) {
        try {
            return CourseCategory.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
