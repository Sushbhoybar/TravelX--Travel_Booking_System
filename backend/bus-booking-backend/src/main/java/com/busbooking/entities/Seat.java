package com.busbooking.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "seats",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "bus_id",
                                "seat_number"
                        })
        })
@Getter
@Setter
@NoArgsConstructor
public class Seat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    @Column(name = "seat_number", nullable = false, length = 10)
    private String seatNumber;

    @Column(name = "row_no", nullable = false)
    private Integer rowNo;

    @Column(name = "column_no", nullable = false)
    private Integer columnNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "deck", nullable = false)
    private DeckType deck;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_category", nullable = false)
    private SeatCategory seatCategory;

    @Column(name = "window_seat", nullable = false)
    private boolean windowSeat;

    @Column(name = "aisle_seat", nullable = false)
    private boolean aisleSeat;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "seat_position", nullable = false)
    private SeatPosition seatPosition;
    
    @OneToMany(
            mappedBy = "seat")
    private List<TripSeat> tripSeats = new ArrayList<>();

}