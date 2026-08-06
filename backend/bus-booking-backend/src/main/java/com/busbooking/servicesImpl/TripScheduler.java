package com.busbooking.servicesImpl;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.busbooking.services.TripService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TripScheduler {

    private final TripService tripService;

    @Scheduled(cron = "0 * * * * *")
    public void updateTrips() {

        System.out.println("Trip Scheduler Running : " + LocalDateTime.now());

        tripService.updateTripStatuses();
    }
}