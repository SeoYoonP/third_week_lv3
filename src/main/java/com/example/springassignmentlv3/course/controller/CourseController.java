package com.example.springassignmentlv3.course.controller;

import com.example.springassignmentlv3.course.dto.CourseRequestDto;
import com.example.springassignmentlv3.course.dto.CourseResponseDto;
import com.example.springassignmentlv3.course.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/register")
    @PreAuthorize("hasAnyRole('MANAGER', 'STAFF')")
    public CourseResponseDto registerCourse(@RequestBody CourseRequestDto courseRequestDto) {
        return courseService.registerCourse(courseRequestDto);
    }

    @PatchMapping("/{courseId}/update")
    @PreAuthorize("hasAnyRole('MANAGER')")
    public CourseResponseDto reviseCourseDetails(@PathVariable Long courseId, @Valid @RequestBody CourseRequestDto courseRequestDto) {
        return courseService.reviseCourseDetails(courseId, courseRequestDto);
    }

}
