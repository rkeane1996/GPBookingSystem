package com.ronansProjects.generalPractionersBookingSystem.controller;

import com.ronansProjects.generalPractionersBookingSystem.model.Booking;
import com.ronansProjects.generalPractionersBookingSystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/gp/booking/")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @GetMapping(value = "getBooking/{patientId}")
    public List<Booking> getBookings(@PathVariable Integer patientId) {
        return bookingService.findPatientBooking(patientId);
    }
    
    @PostMapping(value="makeBooking")
    public Booking makeBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
    
    @DeleteMapping(value = "deleteBooking")
    public void deleteBooking(@RequestBody Booking booking){
        bookingService.deleteBooking(booking); 
    }
    
    @PutMapping(value="editBooking")
    public Booking editBooking(@RequestBody Booking booking) {
        return bookingService.editBooking(booking);
    }
}
