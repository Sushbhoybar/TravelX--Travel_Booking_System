package com.busbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busbooking.entities.Bus;
import com.busbooking.entities.BusImage;

public interface BusImageRepository
        extends JpaRepository<BusImage, Long> {

    List<BusImage> findByBus(Bus bus);
    
    void deleteByBus(Bus bus);

}