//package com.busbooking.repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.busbooking.entities.Schedule;
//import com.busbooking.entities.ScheduleStatus;
//
//public interface ScheduleRepository
//        extends JpaRepository<Schedule, Long> {
//
//    List<Schedule> findByRouteRouteIdAndJourneyDateAndStatus(
//            Long routeId,
//            LocalDate journeyDate,
//            ScheduleStatus status);
//
//}