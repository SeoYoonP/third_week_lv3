package com.example.springassignmentlv3.course.entity;

import com.example.springassignmentlv3.instructor.entity.Instructor;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer price;
    private String description;
    private String category;
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;
}