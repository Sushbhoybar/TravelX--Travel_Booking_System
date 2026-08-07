package com.busbooking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "trip_seats",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "trip_id",
                                "seat_id"
                        })
        })
@Getter
@Setter
@NoArgsConstructor
public class TripSeat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_seat_id")
    private Long tripSeatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "trip_id",
            nullable = false)
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "seat_id",
            nullable = false)
    private Seat seat;

    @Column(nullable = false)
    private Boolean booked = false;

    @Column(nullable = false)
    private Boolean locked = false;

}