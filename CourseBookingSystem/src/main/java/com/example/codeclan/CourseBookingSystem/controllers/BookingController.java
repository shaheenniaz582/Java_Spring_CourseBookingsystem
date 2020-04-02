package com.example.codeclan.CourseBookingSystem.controllers;


import com.example.codeclan.CourseBookingSystem.models.Booking;
import com.example.codeclan.CourseBookingSystem.models.Customer;
import com.example.codeclan.CourseBookingSystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/{id}")
    public ResponseEntity<Optional<Booking>> getBooking(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity(booking, HttpStatus.CREATED);
    }

    @GetMapping

    public ResponseEntity findAllOrFilter(@RequestParam(name="date",required = false) String date){
        if(date!=null){
            return new ResponseEntity(bookingRepository.findByDate(date),HttpStatus.OK);
        }
        return new ResponseEntity(bookingRepository.findAll(),HttpStatus.OK);
    }

}
