package com.example.codeclan.coursebooking.controllers;

import com.example.codeclan.coursebooking.models.Booking;
import com.example.codeclan.coursebooking.models.Customer;
import com.example.codeclan.coursebooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    // INDEX (GET all Customers)
    // GET /customers
    // GET /customers?courseName=Java       findByBookingsCourseName(java)
    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "courseName", required = false) String courseName,
            @RequestParam(name = "customerTown", required = false) String customerTown,
            @RequestParam(name = "age", required = false) Integer age
            )
    {
        if(age != null && customerTown != null && courseName != null){
            List<Customer> townAndNameAndAge =
                    customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age,
                            customerTown, courseName);
            return new ResponseEntity<>(townAndNameAndAge, HttpStatus.OK);
        }
        if(customerTown != null && courseName != null){
            List<Customer> townAndName =
                    customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(customerTown, courseName);
            return new ResponseEntity<>(townAndName, HttpStatus.OK);
        }
        if(courseName != null) {
            List<Customer> course = customerRepository.findByBookingsCourseNameIgnoreCase(courseName);
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        List<Customer> allCustomers = customerRepository.findAll();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    // SHOW (Get Customer by ID)
    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
