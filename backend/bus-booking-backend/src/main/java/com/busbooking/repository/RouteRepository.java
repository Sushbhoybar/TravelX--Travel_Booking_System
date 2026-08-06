package com.busbooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busbooking.entities.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {

	 boolean existsBySourceCityAndDestinationCity(
	            String sourceCity,
	            String destinationCity);

	 Optional<Route> findBySourceCityAndDestinationCity(
	            String sourceCity,
	            String destinationCity);
	 
	 List<Route> findByActiveTrue();

}