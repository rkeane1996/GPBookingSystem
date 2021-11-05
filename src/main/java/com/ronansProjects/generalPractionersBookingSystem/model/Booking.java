package com.ronansProjects.generalPractionersBookingSystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private int bookingId;
    @Column(name = "patientId")
    private String patientId;
    @Column(name = "doctorId")
    private String doctorId;
    @Column(name = "bookingDate")
    private String bookingDate;
    @Column(name = "bookingTime")
    private String bookingTime;

    public Booking(String patientId, String doctorId, String bookingDate, String bookingTime){
        super();
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }
}
