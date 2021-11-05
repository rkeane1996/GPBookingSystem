package com.ronansProjects.generalPractionersBookingSystem.repository;

import com.ronansProjects.generalPractionersBookingSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Integer> {
}
