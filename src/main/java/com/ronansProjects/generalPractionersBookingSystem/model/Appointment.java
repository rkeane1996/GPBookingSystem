package com.ronansProjects.generalPractionersBookingSystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentId")
    private int appointmentId;
    @Column(name = "patientId")
    private String patientId;
    @Column(name = "doctorId")
    private String doctorId;
    @Column(name = "date")
    private Date date;
    @Column(name = "time")
    private String time;

    public Appointment(String patientId, String doctorId, Date date, String time){
        super();
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    public Appointment(){}
}
