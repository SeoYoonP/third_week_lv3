package com.example.springassignmentlv3.course.entity;

import java.util.Arrays;
import java.util.Optional;

public enum CourseCategory {
    SPRING, REACT, NODE;
    // 문자열을 대소문자 구분 없이 CourseCategory enum으로 변환하는 메소드
    public static Optional<CourseCategory> getEnumIgnoreCase(String value) {
        return Arrays.stream(CourseCategory.values())
                .filter(e -> e.name().equalsIgnoreCase(value))
                .findFirst();
    }
}