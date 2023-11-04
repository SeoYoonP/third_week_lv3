package com.example.springassignmentlv3.course.service;

import com.example.springassignmentlv3.course.dto.CourseRequestDto;
import com.example.springassignmentlv3.course.dto.CourseResponseDto;
import com.example.springassignmentlv3.course.entity.Course;
import com.example.springassignmentlv3.course.entity.CourseCategory;
import com.example.springassignmentlv3.course.repository.CourseRepository;
import com.example.springassignmentlv3.exception.CustomException;
import com.example.springassignmentlv3.exception.ErrorCode;
import com.example.springassignmentlv3.instructor.entity.Instructor;
import com.example.springassignmentlv3.instructor.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    public CourseResponseDto registerCourse(CourseRequestDto courseRequestDto) {
        Instructor instructor = validateGetInstructor(courseRequestDto.getInstructorId());
        CourseCategory category = convertToCourseCategory(String.valueOf(courseRequestDto.getCategory()));
        Course course = new Course(instructor, courseRequestDto, category);
        Course savedCourse = courseRepository.save(course);
        return new CourseResponseDto(savedCourse, instructor.getName());
    }

    public CourseResponseDto reviseCourseDetails(Long courseId, CourseRequestDto courseRequestDto) {
        Instructor instructor = validateGetInstructor(courseRequestDto.getInstructorId());
        Course course = validateGetCourse(courseId);
        course.updateCourseDetails(courseRequestDto);
        Course updatedCourse = courseRepository.save(course);
        return new CourseResponseDto(updatedCourse, instructor.getName());
    }

    private Course validateGetCourse(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_COURSE));
    }

    private Instructor validateGetInstructor(Long instructorId) {
        return instructorRepository.findById(instructorId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_INSTRUCTOR));
    }

    // 카테고리 문자열을 CourseCategory enum으로 변환하는 메소드
    private CourseCategory convertToCourseCategory(String categoryStr) {
        return CourseCategory.getEnumIgnoreCase(categoryStr)
                .orElseThrow(() -> new CustomException(ErrorCode.INVALID_CATEGORY));
    }
}
