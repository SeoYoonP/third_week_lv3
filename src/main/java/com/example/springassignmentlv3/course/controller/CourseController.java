package com.example.springassignmentlv3.course.controller;

import com.example.springassignmentlv3.course.dto.InstructorRequestDto;
import com.example.springassignmentlv3.course.dto.InstructorResponseDto;
import com.example.springassignmentlv3.course.service.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/instructors")
public class CourseController {
    private final InstructorService instructorService;

    @PostMapping("/register")
    @PreAuthorize("hasAnyRole('MANAGER', 'STAFF')")
    public InstructorResponseDto registerInstructor(@Valid @RequestBody InstructorRequestDto instructorRequestDto) {
        return instructorService.registerInstructor(instructorRequestDto);
    }

    @PatchMapping("/{instructorId}/update")
    @PreAuthorize("hasAnyAuthority('MANAGER')")
    public InstructorResponseDto reviseInstructorDetails(@PathVariable Long instructorId, @Valid @RequestBody InstructorRequestDto instructorRequestDto) {
        return instructorService.reviseInstructorDetails(instructorId, instructorRequestDto);
    }
}
