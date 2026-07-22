package com.busbooking.entities;

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
    private Long busId;

    @Column(nullable = false)
    private String busName;

    @Column(nullable = false, unique = true)
    private String numberPlate;

    @Column(nullable = false)
    private String busType;

    @Column(nullable = false)
    private Integer totalSeats;

    @Column(nullable = false)
    private String route;

    @Column
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BusStatus status = BusStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private User agent;

}