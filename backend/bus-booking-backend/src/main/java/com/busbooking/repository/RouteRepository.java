//package com.busbooking.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.busbooking.entities.Route;
//
//public interface RouteRepository extends JpaRepository<Route, Long> {
//
//    boolean existsBySourceAndDestination(
//            String source,
//            String destination);
//
//    Optional<Route> findBySourceAndDestination(
//            String source,
//            String destination);
//
//}