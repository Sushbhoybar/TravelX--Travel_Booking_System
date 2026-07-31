package com.busbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busbooking.entities.Bus;
import com.busbooking.entities.Seat;

public interface SeatRepository
        extends JpaRepository<Seat, Long> {

    List<Seat> findByBus(Bus bus);
    
    void deleteByBus(Bus bus);

}