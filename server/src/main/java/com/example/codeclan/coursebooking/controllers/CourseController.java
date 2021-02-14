package com.example.codeclan.coursebooking.controllers;

import com.example.codeclan.coursebooking.models.Booking;
import com.example.codeclan.coursebooking.models.Course;
import com.example.codeclan.coursebooking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    // INDEX (GET all Courses)
    // GET /courses
    // GET /courses?starRating=3        findByStarRating(3)
    // GET /courses?customerName=Dave   findByCustomerName(Dave)
    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name = "starRating", required = false) Integer starRating,
            @RequestParam(name = "customerName", required = false) String customerName
    ) {

        if (starRating != null) {
            List<Course> rating = courseRepository.findByStarRating(starRating);
            return new ResponseEntity<>(rating, HttpStatus.OK);
        }
        if (customerName != null) {
            List<Course> name = courseRepository.findByBookingsCustomerNameIgnoreCase(customerName);
            return new ResponseEntity<>(name, HttpStatus.OK);
        }
        List<Course> allCourses = courseRepository.findAll();
        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }

    // SHOW (Get Course by ID)
    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<Optional<Course>> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}
