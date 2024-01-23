package com.mahindrafinance.assignment.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BookingDetails")
public class Booking {

    @Id
    @Column(unique = true,nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    String bookingId;
    String userId;
    String advisorId;
    String bookingTime;

}
