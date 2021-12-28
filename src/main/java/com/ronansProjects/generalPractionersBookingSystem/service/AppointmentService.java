package com.ronansProjects.generalPractionersBookingSystem.service;

import com.ronansProjects.generalPractionersBookingSystem.model.Appointment;
import com.ronansProjects.generalPractionersBookingSystem.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    public List<Appointment> getAllAppointments(){
        return appointmentRepo.findAll();
    }

    public List<Appointment> findPatientAppointment(String patientId) {
        return appointmentRepo.retrievePatientAppointments(patientId);
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public void deleteAppointment(Appointment appointment) {
        appointmentRepo.delete(appointment);
    }

    public Appointment editAppointment(Appointment appointment) {
        Appointment newBooking = appointmentRepo.getById(appointment.getAppointmentId());
        newBooking.setDate(appointment.getDate());
        newBooking.setTime(appointment.getTime());
        newBooking.setPatientId(appointment.getPatientId());
        newBooking.setDoctorId(appointment.getDoctorId());
        return appointmentRepo.save(newBooking);
    }

    public List<Appointment> getDoctorsDailyAppointments(String doctorId){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return appointmentRepo.retrieveDoctorsAppointments(dateFormat.format(date),doctorId);}
}
