package com.ronansProjects.generalPractionersBookingSystem.controller;

import com.ronansProjects.generalPractionersBookingSystem.model.Patient;
import com.ronansProjects.generalPractionersBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/gp/user/")
public class PatientController {
    
    @Autowired
    private PatientService patientService;
    
    @GetMapping(value="retrieveuser/{patientId}")
    public Patient retrievePatient(@PathVariable Integer patientId) {
        return patientService.getPatientDetails(patientId);
    }
    
    @PostMapping(value="createPatient")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }
    
    @PutMapping(value="editPatient")
    public Patient editPatient(@RequestBody Patient patient) {
        return patientService.editPatient(patient);
    }
    
    
}
