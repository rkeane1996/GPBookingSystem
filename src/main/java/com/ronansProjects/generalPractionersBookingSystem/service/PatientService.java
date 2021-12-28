package com.ronansProjects.generalPractionersBookingSystem.service;

import com.ronansProjects.generalPractionersBookingSystem.model.Patient;
import com.ronansProjects.generalPractionersBookingSystem.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public Patient getPatientDetails(Integer patientId){
        return patientRepo.findById(patientId).get();
    }

    public List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }

    public Patient savePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public Patient editPatient(Patient updatedPatientDetails) {
        Patient patient = patientRepo.getById(updatedPatientDetails.getPatientId());
        patient.setAddress(updatedPatientDetails.getAddress());
        patient.setEmail(updatedPatientDetails.getEmail());
        patient.setMobile(updatedPatientDetails.getMobile());
        return patientRepo.save(patient);
    }
}
