package com.busbooking.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trips")
@Getter
@Setter
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long tripId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    @Column(name = "departure_datetime", nullable = false)
    private LocalDateTime departureDateTime;

    @Column(name = "arrival_datetime", nullable = false)
    private LocalDateTime arrivalDateTime;

    @Column(name = "base_fare", nullable = false, precision = 10, scale = 2)
    private BigDecimal baseFare;

    @Column(name = "available_seats", nullable = false)
    private Integer availableSeats;

    @Enumerated(EnumType.STRING)
    @Column(name = "trip_status", nullable = false)
    private TripStatus tripStatus;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable =false)
    private LocalDateTime updatedAt;
    
    @OneToMany(
            mappedBy = "trip",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<TripSeat> tripSeats = new ArrayList<>();

    @PrePersist
    public void prePersist() {

        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if (tripStatus == null) {
            tripStatus = TripStatus.SCHEDULED;
        }

    }

    @PreUpdate
    public void preUpdate() {

        updatedAt = LocalDateTime.now();

    }

}