package com.example.codeclan.CourseBookingSystem;

import com.example.codeclan.CourseBookingSystem.repository.BookingRepository;
import com.example.codeclan.CourseBookingSystem.repository.CourseRepository;
import com.example.codeclan.CourseBookingSystem.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseBookingSystemApplicationTests {

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

	public void bookingByDate(){
		bookingRepository.findByDate("13-9-2019");
	}

}
