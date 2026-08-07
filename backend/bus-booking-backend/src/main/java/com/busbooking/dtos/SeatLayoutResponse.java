package com.busbooking.dtos;

import com.busbooking.entities.DeckType;
import com.busbooking.entities.SeatCategory;
import com.busbooking.entities.SeatPosition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatLayoutResponse {

    private Long tripSeatId;

    private Long seatId;

    private String seatNumber;

    private Integer rowNo;

    private Integer columnNo;

    private DeckType deck;

    private SeatCategory seatCategory;

    private SeatPosition seatPosition;

    private Boolean booked;

    private Boolean locked;

}