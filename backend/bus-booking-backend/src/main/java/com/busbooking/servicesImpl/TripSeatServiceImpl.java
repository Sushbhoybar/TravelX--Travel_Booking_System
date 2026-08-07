package com.busbooking.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busbooking.entities.Seat;
import com.busbooking.entities.Trip;
import com.busbooking.entities.TripSeat;
import com.busbooking.repository.SeatRepository;
import com.busbooking.repository.TripSeatRepository;
import com.busbooking.services.TripSeatService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TripSeatServiceImpl implements TripSeatService {

    private final SeatRepository seatRepository;

    private final TripSeatRepository tripSeatRepository;

    @Override
    public void generateTripSeats(Trip trip) {

        if (tripSeatRepository.countByTrip(trip) > 0) {
            return;
        }

        List<Seat> seats =
                seatRepository.findByBusOrderByRowNoAscColumnNoAsc(
                        trip.getBus());

        List<TripSeat> tripSeats = new ArrayList<>();

        for (Seat seat : seats) {

            TripSeat tripSeat = new TripSeat();

            tripSeat.setTrip(trip);

            tripSeat.setSeat(seat);

            tripSeat.setBooked(false);

            tripSeat.setLocked(false);

            tripSeats.add(tripSeat);

        }

        tripSeatRepository.saveAll(tripSeats);

    }

}