package com.busbooking.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "routes",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "source_city",
                                "destination_city"
                        })
        })
@Getter
@Setter
@NoArgsConstructor
public class Route extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "source_city",
            nullable = false,
            length = 100)
    private String sourceCity;

    @Column(name = "destination_city",
            nullable = false,
            length = 100)
    private String destinationCity;

    @Column(nullable = false)
    private Integer distanceKm;

    @Column(nullable = false)
    private Integer estimatedDurationMinutes;

    @Column(nullable = false)
    private Boolean active = true;

    @OneToMany(
            mappedBy = "route",
            cascade = CascadeType.ALL)
    private List<Trip> trips = new ArrayList<>();

}