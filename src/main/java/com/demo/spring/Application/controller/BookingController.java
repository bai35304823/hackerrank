package com.demo.spring.Application.controller;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.Application.model.Booking;
import com.demo.spring.Application.repository.BookingRepository;



@RestController
@RequestMapping("/api/v2")
public class BookingController {
//    Interface representing the environment in which the current application is running
    @Autowired
    private Environment environment;
    @Autowired
    private BookingRepository bookingRepository;
    
    @PostMapping("/booking/addOne")
    public Booking addBooking(@RequestBody Booking booking) {
    	return bookingRepository.save(booking);
    }
    
    @PostMapping("/booking/delOne")
    public void deleteBooking(@RequestBody Booking booking) {
    	bookingRepository.deleteById(booking.getBookingId());
    }
    
    
    @GetMapping("/booking/getAll")
    public List<Booking> getAll() {
    	return bookingRepository.findAll();
    }
}
