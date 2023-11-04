package com.example.springassignmentlv3.course.entity;

import com.example.springassignmentlv3.course.dto.CourseRequestDto;
import com.example.springassignmentlv3.course.service.CourseService;
import com.example.springassignmentlv3.instructor.entity.Instructor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseCategory category;
    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;
    @Column(nullable = false)
    private LocalDate registrationDate;

    public Course(Instructor instructor, CourseRequestDto courseRequestDto, CourseCategory category) {
        this.title = courseRequestDto.getTitle();
        this.price = courseRequestDto.getPrice();
        this.description = courseRequestDto.getDescription();
        this.category = category;
        this.instructor = instructor;
        this.registrationDate = LocalDate.now();
    }
}