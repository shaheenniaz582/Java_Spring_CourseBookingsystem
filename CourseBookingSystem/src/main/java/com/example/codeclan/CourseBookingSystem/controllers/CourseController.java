package com.example.codeclan.CourseBookingSystem.controllers;


import com.example.codeclan.CourseBookingSystem.models.Course;
import com.example.codeclan.CourseBookingSystem.models.Customer;
import com.example.codeclan.CourseBookingSystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value="/{id}")
    public ResponseEntity<Optional<Course>> getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity(course, HttpStatus.CREATED);
    }

    @GetMapping

    public  ResponseEntity findAllOrFilter(@RequestParam(name = "rating",required = false) Integer rating,
                                           @RequestParam(name ="customer",required = false) String customer){
        if(rating!=null){
            return new ResponseEntity(courseRepository.findByRating(rating),HttpStatus.OK);
        }
        if(customer!=null){
            return new ResponseEntity(courseRepository.findByBookingsCustomerNameIgnoreCase(customer),HttpStatus.OK);
        }
        return new ResponseEntity(courseRepository.findAll(),HttpStatus.OK);
    }

}
