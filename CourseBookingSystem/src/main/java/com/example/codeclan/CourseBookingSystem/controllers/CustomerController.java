package com.example.codeclan.CourseBookingSystem.controllers;

import com.example.codeclan.CourseBookingSystem.models.Customer;
import com.example.codeclan.CourseBookingSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value="/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity(customer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity findAllOrFilter(@RequestParam(name="course",required = false) String course,
                                          @RequestParam(name ="town", required = false) String town,
                                          @RequestParam(name = "age",required = false) Integer age) {
        if (course!=null && town==null ){
            return new ResponseEntity(customerRepository.findByBookingsCourseNameIgnoreCase(course),HttpStatus.OK);
        }

        if(course!=null && town != null && age==null){
            return new ResponseEntity(customerRepository.findByTownAndBookingsCourseNameAllIgnoreCase(town,course),HttpStatus.OK);
        }

        if(course!=null && town!=null && age!=null){
            return new ResponseEntity(customerRepository.findByAgeGreaterThanEqualAndTownAndBookingsCourseNameAllIgnoreCase(age,town,course),HttpStatus.OK);
        }

        return new ResponseEntity(customerRepository.findAll(),HttpStatus.OK);
    }

}
