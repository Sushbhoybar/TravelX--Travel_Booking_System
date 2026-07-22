package com.busbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.busbooking.entities.Bus;
import com.busbooking.entities.BusStatus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

    List<Bus> findByStatus(BusStatus status);

}