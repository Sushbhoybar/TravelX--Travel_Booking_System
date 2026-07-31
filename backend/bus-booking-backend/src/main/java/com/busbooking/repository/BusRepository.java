package com.busbooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busbooking.entities.Bus;
import com.busbooking.entities.BusStatus;
import com.busbooking.entities.User;

public interface BusRepository extends JpaRepository<Bus, Long> {

	List<Bus> findByAgent(User agent);

	Optional<Bus> findByBusIdAndAgent(
	        Long busId,
	        User agent);

	boolean existsByRegistrationNumber(
	        String registrationNumber);
	
	long countByAgent(User agent);

	long countByAgentAndStatus(
	        User agent,
	        BusStatus status);

}