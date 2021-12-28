package com.ronansProjects.generalPractionersBookingSystem.controller;

import com.ronansProjects.generalPractionersBookingSystem.model.Appointment;
import com.ronansProjects.generalPractionersBookingSystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/gp/appointment/")
public class AppointmentController {
    
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(value = "getPatientAppointments/{patientId}")
    public List<Appointment> getPatientsAppointments(@PathVariable String patientId) {
        return appointmentService.findPatientAppointment(patientId);
    }
    
    @PostMapping(value="makeAppointment")
    public Appointment makeAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }
    
    @DeleteMapping(value = "deleteAppointment")
    public void deleteBooking(@RequestBody Appointment appointment){
        appointmentService.deleteAppointment(appointment);
    }
    
    @PutMapping(value="editAppointment")
    public Appointment editBooking(@RequestBody Appointment appointment) {
        return appointmentService.editAppointment(appointment);
    }
    
    @GetMapping(value="doctorsAppointments/{doctorId}")
    public List<Appointment> getDoctorsAppointments(String doctorId){
        return appointmentService.getDoctorsDailyAppointments(doctorId);
    }

}
