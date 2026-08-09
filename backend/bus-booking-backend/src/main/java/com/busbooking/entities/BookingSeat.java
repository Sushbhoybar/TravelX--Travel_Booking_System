package com.busbooking.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "booking_seats",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "booking_id",
                                "trip_seat_id"
                        }
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class BookingSeat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_seat_id")
    private Long bookingSeatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "booking_id",
            nullable = false
    )
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "trip_seat_id",
            nullable = false
    )
    private TripSeat tripSeat;

    /*
     * Snapshot of the seat number at booking time.
     *
     * This is intentional denormalization because the
     * booking should preserve what the customer booked
     * even if the underlying seat configuration changes.
     */
    @Column(
            name = "seat_number",
            nullable = false,
            length = 20
    )
    private String seatNumber;

    /*
     * Fare charged for this particular seat.
     */
    @Column(
            name = "fare",
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal fare;
}