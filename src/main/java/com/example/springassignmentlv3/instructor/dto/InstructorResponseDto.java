package com.example.springassignmentlv3.instructor.dto;

import com.example.springassignmentlv3.instructor.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InstructorResponseDto {
    private String name;
    private int experience;
    private String company;
    private String phoneNumber;
    private String bio;

    public InstructorResponseDto(Instructor saveInstructor) {
        this.name = saveInstructor.getName();
        this.experience = saveInstructor.getExperience();
        this.company = saveInstructor.getCompany();
        this.phoneNumber = saveInstructor.getPhoneNumber();
        this.bio = saveInstructor.getBio();
    }
}
