package com.ronansProjects.generalPractionersBookingSystem.service;

import com.ronansProjects.generalPractionersBookingSystem.model.Doctor;
import com.ronansProjects.generalPractionersBookingSystem.repository.AppointmentRepo;
import com.ronansProjects.generalPractionersBookingSystem.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public Doctor getDoctor(Integer docId) {
        return doctorRepo.findById(docId).get();
    }

    public List<Doctor> getAllAvailableDoctors(String time, String date) {
        List<Doctor> availableDocs = new ArrayList<>();
        List<Doctor> allDoc = getAllDoctors();
        List<Integer> unavailableDoc = appointmentRepo.findAvailableDoctors(date, time);
        for (Doctor doc: allDoc){
            if(!unavailableDoc.contains(doc.getDoctorid())){
                availableDocs.add(doc);
            }
        }
        return availableDocs;
    }
}
