package com.ronansProjects.generalPractionersBookingSystem.repository;

import com.ronansProjects.generalPractionersBookingSystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

    @Query(value = "Select doctorId FROM Booking WHERE bookingDate =?1 AND bookingTime=?2",
            nativeQuery = true)
    List<Integer> findAvailableDoctors(String bookingDate, String bookingTime);
}
