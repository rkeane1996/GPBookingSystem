package com.ronansProjects.generalPractionersBookingSystem.repository;

import com.ronansProjects.generalPractionersBookingSystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
