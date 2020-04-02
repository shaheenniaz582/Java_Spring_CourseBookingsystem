package com.example.codeclan.CourseBookingSystem.components;

import com.example.codeclan.CourseBookingSystem.models.Booking;
import com.example.codeclan.CourseBookingSystem.models.Course;
import com.example.codeclan.CourseBookingSystem.models.Customer;
import com.example.codeclan.CourseBookingSystem.repository.BookingRepository;
import com.example.codeclan.CourseBookingSystem.repository.CourseRepository;
import com.example.codeclan.CourseBookingSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args) {
        Course Java = new Course("Java", "Glasgow",5);
        Course Ruby = new Course("Ruby", "Paisely",4);
        Course Python = new Course("Python", "Edinburgh",1);
        Course JavaScript = new Course("JavaScript", "Falkirk",3);
        Course CSharp = new Course("CSharp", "Glasgow",5);
        courseRepository.save(Java);
        courseRepository.save(Ruby);
        courseRepository.save(Python);
        courseRepository.save(JavaScript);
        courseRepository.save(CSharp);

        Customer Steven = new Customer("Steven", "Glasgow", 24);
        Customer Shaheen = new Customer("Shaheen", "Paisely", 33);
        Customer Peter = new Customer("Peter", "Edinburgh", 27);
        customerRepository.save(Steven);
        customerRepository.save(Shaheen);
        customerRepository.save(Peter);

        Booking booking = new Booking("13-9-2019",Java, Steven);

        Booking booking1 = new Booking("13-9-2019", Java, Peter);
        Booking booking2 = new Booking("22-10-2018", Ruby, Shaheen);
        Booking booking3 = new Booking("01-01-2020", JavaScript,Shaheen );

        bookingRepository.save(booking);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);


    }
}
