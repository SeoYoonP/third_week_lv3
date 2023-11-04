package com.example.springassignmentlv3.course.repository;

import com.example.springassignmentlv3.course.entity.Course;
import com.example.springassignmentlv3.instructor.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructorOrderByRegistrationDateDesc(Instructor instructor);
}
