package com.example.codeclan.coursebooking.controllers;

import com.example.codeclan.coursebooking.models.Booking;
import com.example.codeclan.coursebooking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.OutputKeys;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    // INDEX (GET all Bookings)
    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(name = "bookingDate", required = false) String date
    ) {
        if(date != null){
            List<Booking> bookingDate = bookingRepository.findByDate(date);
            return new ResponseEntity<>(bookingDate, HttpStatus.OK);
        }


        List<Booking> allBookings = bookingRepository.findAll();
        return new ResponseEntity<>(allBookings, HttpStatus.OK);
    }

    // SHOW (Get Booking by ID)
    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity<Optional<Booking>> getBookingById(@PathVariable Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    // CREATE (POST request)
    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking newBooking) {
        Booking createdBooking = bookingRepository.save(newBooking);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    // UPDATE (PUT request)


    // DELETE
}
