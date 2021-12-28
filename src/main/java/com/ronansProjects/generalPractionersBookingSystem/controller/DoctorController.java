package com.ronansProjects.generalPractionersBookingSystem.controller;

import com.ronansProjects.generalPractionersBookingSystem.model.Doctor;
import com.ronansProjects.generalPractionersBookingSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/gp/doctor/")
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;
    
    @PostMapping("createDoctor")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorService.saveDoctor(doctor);
    }
    
    @GetMapping(value="getAllDoctors")
    public List<Doctor> getDoctors() {
        return doctorService.getAllDoctors();
    }
    
    @GetMapping(value="getDoctor/{docId}")
    public Doctor getDoctor(@PathVariable Integer docId) {
        return doctorService.getDoctor(docId);
    }
    
    @GetMapping(value="availableDoctors/")
    public List<Doctor> getAvailableDoctors(@RequestParam String time, @RequestParam String date) {
        return doctorService.getAllAvailableDoctors(time,date);
    }

}
