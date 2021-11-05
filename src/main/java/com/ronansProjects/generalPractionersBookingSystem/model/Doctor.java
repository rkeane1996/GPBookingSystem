package com.ronansProjects.generalPractionersBookingSystem.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctorId")
    private int doctorid;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public Doctor(){}

    public Doctor(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }
}
