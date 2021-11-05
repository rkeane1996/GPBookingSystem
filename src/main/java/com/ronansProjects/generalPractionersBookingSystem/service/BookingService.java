package com.ronansProjects.generalPractionersBookingSystem.service;

import com.ronansProjects.generalPractionersBookingSystem.model.Booking;
import com.ronansProjects.generalPractionersBookingSystem.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public List<Booking> getAllBookings(){
        return bookingRepo.findAll();
    }

    public List<Booking> findPatientBooking(Integer patientId) {
        List<Booking> allBookings = getAllBookings();
        List<Booking> bookings = new ArrayList<>();
        for (Booking booking: allBookings) {
            if (booking.getPatientId().equals(patientId)){
                bookings.add(booking);
            }
        }
        return bookings;
    }

    public Booking createBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    public void deleteBooking(Booking booking) {
        bookingRepo.delete(booking);
    }

    public Booking editBooking(Booking booking) {
        Booking newBooking = bookingRepo.getById(booking.getBookingId());
        newBooking.setBookingDate(booking.getBookingDate());
        newBooking.setBookingTime(booking.getBookingTime());
        newBooking.setPatientId(booking.getPatientId());
        newBooking.setDoctorId(booking.getDoctorId());
        return bookingRepo.save(newBooking);
    }
}
