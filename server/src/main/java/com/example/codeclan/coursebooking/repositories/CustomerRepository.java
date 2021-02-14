package com.example.codeclan.coursebooking.repositories;

import com.example.codeclan.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // MVP
    // Get all customers for a given course
    List<Customer> findByBookingsCourseNameIgnoreCase(String courseName);
    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String courseName);
    List<Customer> findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(int age, String town,
                                                                                          String courseName
                                                                                );
}
