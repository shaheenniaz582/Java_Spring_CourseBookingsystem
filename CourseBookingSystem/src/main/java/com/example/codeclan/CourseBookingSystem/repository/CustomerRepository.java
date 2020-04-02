package com.example.codeclan.CourseBookingSystem.repository;

import com.example.codeclan.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String name);
    List<Customer> findByTownAndBookingsCourseNameAllIgnoreCase(String town, String name);
    List<Customer> findByAgeGreaterThanEqualAndTownAndBookingsCourseNameAllIgnoreCase(int age, String town, String course);
}
