package com.example.codeclan.coursebooking;

import com.example.codeclan.coursebooking.models.Booking;
import com.example.codeclan.coursebooking.models.Course;
import com.example.codeclan.coursebooking.models.Customer;
import com.example.codeclan.coursebooking.repositories.BookingRepository;
import com.example.codeclan.coursebooking.repositories.CourseRepository;
import com.example.codeclan.coursebooking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoursebookingApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canCreateAndSave() {
		Course course = new Course("Intro to Python", "Glasgow", 3);
		courseRepository.save(course);

		Customer customer = new Customer("Ailsa", "Edinburgh", 27);
		customerRepository.save(customer);

		Booking booking = new Booking("11-02-21", course, customer);
		bookingRepository.save(booking);

	}
}
