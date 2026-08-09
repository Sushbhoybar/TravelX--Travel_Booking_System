package com.busbooking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "booking_passengers")
@Getter
@Setter
@NoArgsConstructor
public class BookingPassenger extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_passenger_id")
    private Long bookingPassengerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "booking_id",
            nullable = false
    )
    private Booking booking;

    @Column(
            name = "name",
            nullable = false,
            length = 100
    )
    private String name;

    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

    @Column(
            name = "gender",
            nullable = false,
            length = 20
    )
    private String gender;

    @Column(
            name = "phone",
            length = 15
    )
    private String phone;

    @Column(
            name = "email",
            length = 100
    )
    private String email;
}