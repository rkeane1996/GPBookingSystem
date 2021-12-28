package com.ronansProjects.generalPractionersBookingSystem.repository;

import com.ronansProjects.generalPractionersBookingSystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

    @Query(value = "Select doctorId FROM Appointment WHERE date =?1 AND time=?2",
            nativeQuery = true)
    List<Integer> findAvailableDoctors(String date, String time);

    @Query(value = "Select * FROM Appointment WHERE date =?1 AND doctorId=?2",
            nativeQuery = true)
    List<Appointment> retrieveDoctorsAppointments(String date, String doctorId);

    @Query(value = "Select * FROM Appointment WHERE patientId=?1",
            nativeQuery = true)
    List<Appointment> retrievePatientAppointments(String patientId);


}
