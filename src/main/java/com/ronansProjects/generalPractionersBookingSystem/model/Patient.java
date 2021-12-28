package com.ronansProjects.generalPractionersBookingSystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientId")
    private int patientId;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "dob")
    private String dob;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "email")
    private String email;

    public Patient(String name, String address, String dob, String mobile, String email){
        super();
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.mobile = mobile;
        this.email = email;
    }

    public Patient(){}
}
