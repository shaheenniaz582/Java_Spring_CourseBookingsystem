package com.example.codeclan.CourseBookingSystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String town;

    @Column
    private int rating;

    @JsonBackReference
    @OneToMany(mappedBy = "course")
    private List<Booking> bookings;
    public Course(String name, String town, int rating) {
        this.name = name;
        this.town = town;
        this.rating = rating;
        bookings = new ArrayList<Booking>();
    }

    public Course(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getStarRating() {
        return rating;
    }

    public void setStarRating(int starRating) {
        this.rating = rating;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking)
    {
        this.bookings.add(booking);
    }
}
