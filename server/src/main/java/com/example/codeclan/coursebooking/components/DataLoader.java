package com.example.codeclan.coursebooking.components;

import com.example.codeclan.coursebooking.models.Booking;
import com.example.codeclan.coursebooking.models.Course;
import com.example.codeclan.coursebooking.models.Customer;
import com.example.codeclan.coursebooking.repositories.BookingRepository;
import com.example.codeclan.coursebooking.repositories.CourseRepository;
import com.example.codeclan.coursebooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Course java = new Course("Intro to Java", "Glasgow", 3);
        courseRepository.save(java);
        Course python = new Course("Python", "Edinburgh", 4);
        courseRepository.save(python);
        Course javascript = new Course("Javascript", "Aberdeen", 3);
        courseRepository.save(javascript);
        Course ux = new Course("UX Design", "Glasgow", 3);
        courseRepository.save(ux);

        Customer ailsa = new Customer("Ailsa", "Edinburgh", 27);
        customerRepository.save(ailsa);
        Customer dave = new Customer("Dave", "Glasgow", 35);
        customerRepository.save(dave);
        Customer kirsty = new Customer("Kirsty", "Glasgow", 24);
        customerRepository.save(kirsty);
        Customer stewart = new Customer("Stewart", "Edinburgh", 33);
        customerRepository.save(stewart);

        Booking booking1 = new Booking("14-02-21", java, ailsa);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("14-02-21", java, dave);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("14-02-21", python, dave);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("05-03-21", python, stewart);
        bookingRepository.save(booking4);
        Booking booking5 = new Booking("05-03-21", python, kirsty);
        bookingRepository.save(booking5);
        Booking booking6 = new Booking("15-03-21", javascript, ailsa);
        bookingRepository.save(booking6);
        Booking booking7 = new Booking("15-03-21", javascript, dave);
        bookingRepository.save(booking7);
        Booking booking8 = new Booking("12-03-21", javascript, stewart);
        bookingRepository.save(booking8);
        Booking booking9 = new Booking("12-03-21", javascript, kirsty);
        bookingRepository.save(booking9);
        Booking booking10 = new Booking("28-02-21", ux, dave);
        bookingRepository.save(booking10);
        Booking booking11 = new Booking("26-02-21", ux, kirsty);
        bookingRepository.save(booking11);

    }
}
