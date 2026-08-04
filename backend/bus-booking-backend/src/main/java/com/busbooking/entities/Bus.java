package com.busbooking.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "buses")
@Getter
@Setter
@NoArgsConstructor
public class Bus extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long busId;

    @Column(name = "bus_name", nullable = false, length = 100)
    private String busName;

    @Column(name = "registration_number", nullable = false, unique = true)
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "bus_type", nullable = false)
    private BusType busType;

    @Column(name = "total_seats", nullable = false)
    private Integer totalSeats;

    @Column(length = 500)
    private String amenities;

    @Column(name = "insurance_document")
    private String insuranceDocument;

    @Column(name = "registration_certificate")
    private String registrationCertificate;

    @Column(name = "fitness_certificate")
    private String fitnessCertificate;

    @Column(name = "permit_document")
    private String permitDocument;

    @Column(name = "pollution_certificate")
    private String pollutionCertificate;
    

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BusStatus status = BusStatus.PENDING;
    
    @Column(name = "admin_remarks", columnDefinition = "TEXT")
    private String adminRemarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User agent;

    @OneToMany(
            mappedBy = "bus",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(
            mappedBy = "bus",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<BusImage> images = new ArrayList<>();

    @OneToMany(
            mappedBy = "bus",
            cascade = CascadeType.ALL)
    private List<Trip> trips = new ArrayList<>();

}