package com.example.codeclan.CourseBookingSystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String town;

    @Column
    private int age;

    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;

    public Customer(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
        this.bookings = new ArrayList<>();
    }

    public Customer(){}

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }



    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }
}
