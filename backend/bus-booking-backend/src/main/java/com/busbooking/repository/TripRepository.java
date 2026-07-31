//package com.busbooking.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.busbooking.entities.Bus;
//import com.busbooking.entities.Trip;
//
//public interface TripRepository
//        extends JpaRepository<Trip, Long> {
//
//    List<Trip> findByBus(Bus bus);
//
//}