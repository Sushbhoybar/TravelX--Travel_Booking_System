package com.busbooking.servicesImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busbooking.custom_exception.BusinessException;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.RouteResponse;
import com.busbooking.dtos.AgentBusResponse;
import com.busbooking.dtos.CreateTripRequest;
import com.busbooking.dtos.TripDetailsResponse;
import com.busbooking.dtos.TripResponse;
import com.busbooking.entities.Agent;
import com.busbooking.entities.Bus;
import com.busbooking.entities.BusStatus;
import com.busbooking.entities.Route;
import com.busbooking.entities.Trip;
import com.busbooking.entities.TripStatus;
import com.busbooking.repository.AgentRepository;
import com.busbooking.repository.BusRepository;
import com.busbooking.repository.RouteRepository;
import com.busbooking.repository.TripRepository;
import com.busbooking.services.TripService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

	private final TripRepository tripRepository;

	private final BusRepository busRepository;

	private final RouteRepository routeRepository;

	private final AgentRepository agentRepository;

	// =========================================================
	// CREATE TRIP
	// =========================================================

	@Override
	public ApiResponse createTrip(CreateTripRequest request, String email) {

		Agent agent = agentRepository.findByUserEmail(email)
				.orElseThrow(() -> new BusinessException("Agent not found"));

		Bus bus = busRepository.findById(request.getBusId()).orElseThrow(() -> new BusinessException("Bus not found"));

		if (!bus.getAgent().getUserId().equals(agent.getUserId())) {
			throw new BusinessException("You are not authorized to use this bus.");
		}

		if (bus.getStatus() != BusStatus.APPROVED) {
			throw new BusinessException("Only approved buses can be assigned to trips.");
		}

		Route route = routeRepository.findById(request.getRouteId())
				.orElseThrow(() -> new BusinessException("Route not found"));

		if (request.getDepartureDateTime().isBefore(LocalDateTime.now())) {
			throw new BusinessException("Departure date/time must be in the future.");
		}

		if (!request.getArrivalDateTime().isAfter(request.getDepartureDateTime())) {

			throw new BusinessException("Arrival date/time must be after departure date/time.");
		}

		Trip trip = new Trip();

		trip.setBus(bus);

		trip.setRoute(route);

		trip.setDepartureDateTime(request.getDepartureDateTime());

		trip.setArrivalDateTime(request.getArrivalDateTime());

		trip.setBaseFare(request.getBaseFare());

		trip.setAvailableSeats(bus.getTotalSeats());

		trip.setTripStatus(TripStatus.SCHEDULED);

		tripRepository.save(trip);

		return new ApiResponse("Trip created successfully.");

	}

	// =========================================================
	// GET MY TRIPS
	// =========================================================

	@Override
	@Transactional(readOnly = true)
	public List<TripResponse> getMyTrips(String email) {

		Agent agent = agentRepository.findByUserEmail(email)
				.orElseThrow(() -> new BusinessException("Agent not found"));

		return tripRepository.findByBusAgentUserId(agent.getUserId()).stream().map(this::mapToTripResponse).toList();
	}

	// =========================================================
	// GET TRIP DETAILS
	// =========================================================

	@Override
	@Transactional(readOnly = true)
	public TripDetailsResponse getTripDetails(Long tripId, String email) {

		Agent agent = agentRepository.findByUserEmail(email)
				.orElseThrow(() -> new BusinessException("Agent not found"));

		Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new BusinessException("Trip not found"));

		if (!trip.getBus().getAgent().getUserId().equals(agent.getUserId())) {
			throw new BusinessException("You are not authorized to view this trip.");
		}

		TripDetailsResponse response = new TripDetailsResponse();

		response.setTripId(trip.getTripId());

		response.setBusId(trip.getBus().getBusId());

		response.setBusName(trip.getBus().getBusName());

		response.setRegistrationNumber(trip.getBus().getRegistrationNumber());

		response.setRouteId(trip.getRoute().getRouteId());

		response.setSourceCity(trip.getRoute().getSourceCity());

		response.setDestinationCity(trip.getRoute().getDestinationCity());

		response.setDepartureDateTime(trip.getDepartureDateTime());

		response.setArrivalDateTime(trip.getArrivalDateTime());

		response.setBaseFare(trip.getBaseFare());

		response.setTotalSeats(trip.getBus().getTotalSeats());

		response.setAvailableSeats(trip.getAvailableSeats());

		response.setTripStatus(trip.getTripStatus());

		return response;
	}

//=========================================================
//CANCEL TRIP
//=========================================================

	@Override
	public ApiResponse cancelTrip(Long tripId, String email) {

		Agent agent = agentRepository.findByUserEmail(email)
				.orElseThrow(() -> new BusinessException("Agent not found"));

		Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new BusinessException("Trip not found"));

		if (!trip.getBus().getAgent().getUserId().equals(agent.getUserId())) {
			throw new BusinessException("You are not authorized to cancel this trip.");
		}

		if (trip.getTripStatus() != TripStatus.SCHEDULED) {
			throw new BusinessException("Only scheduled trips can be cancelled.");
		}

		if (trip.getDepartureDateTime().isBefore(LocalDateTime.now())) {
			throw new BusinessException("Trip has already started.");
		}

		trip.setTripStatus(TripStatus.CANCELLED);

		tripRepository.save(trip);

		return new ApiResponse("Trip cancelled successfully.");
	}

//=========================================================
//AUTO COMPLETE TRIPS
//=========================================================

	@Override
	public List<AgentBusResponse> getApprovedBuses(String email) {

		Agent agent = agentRepository.findByUserEmail(email)
				.orElseThrow(() -> new BusinessException("Agent not found"));

		return busRepository.findByAgentUserIdAndStatus(agent.getUserId(), BusStatus.APPROVED).stream()
				.map(this::mapToAgentBusResponse).toList();

	}

	@Override
	public List<RouteResponse> getActiveRoutes() {

		return routeRepository.findByActiveTrue().stream().map(this::mapToRouteResponse).toList();

	}

//=========================================================
//MAPPER
//=========================================================

	private TripResponse mapToTripResponse(Trip trip) {

		TripResponse response = new TripResponse();

		response.setTripId(trip.getTripId());

		response.setBusName(trip.getBus().getBusName());

		response.setRegistrationNumber(trip.getBus().getRegistrationNumber());

		response.setSourceCity(trip.getRoute().getSourceCity());

		response.setDestinationCity(trip.getRoute().getDestinationCity());

		response.setDepartureDateTime(trip.getDepartureDateTime());

		response.setArrivalDateTime(trip.getArrivalDateTime());

		response.setBaseFare(trip.getBaseFare());

		response.setAvailableSeats(trip.getAvailableSeats());

		response.setTripStatus(trip.getTripStatus());

		return response;
	}

	private AgentBusResponse mapToAgentBusResponse(Bus bus) {

		AgentBusResponse response = new AgentBusResponse();

		response.setBusId(bus.getBusId());

		response.setBusName(bus.getBusName());

		response.setRegistrationNumber(bus.getRegistrationNumber());

		response.setBusType(bus.getBusType());

		response.setTotalSeats(bus.getTotalSeats());

		response.setStatus(bus.getStatus());

		response.setAdminRemarks(bus.getAdminRemarks());

		response.setCanEdit(false);

		response.setCanDelete(false);

		return response;

	}

	private RouteResponse mapToRouteResponse(Route route) {

		RouteResponse response = new RouteResponse();

		response.setRouteId(route.getRouteId());

		response.setSourceCity(route.getSourceCity());

		response.setDestinationCity(route.getDestinationCity());

		response.setDistanceKm(route.getDistanceKm());

		response.setEstimatedDurationMinutes(route.getEstimatedDurationMinutes());

		response.setActive(route.getActive());

		return response;

	}

	@Override
	@Transactional
	public void updateTripStatuses() {

	    LocalDateTime now = LocalDateTime.now();

	    List<Trip> trips = tripRepository.findAll(); 

	    for (Trip trip : trips) {

	        if (trip.getTripStatus() == TripStatus.CANCELLED ||
	            trip.getTripStatus() == TripStatus.COMPLETED) {
	            continue;
	        }

	        if (trip.getTripStatus() == TripStatus.SCHEDULED &&
	            !now.isBefore(trip.getDepartureDateTime())) {

	            trip.setTripStatus(TripStatus.RUNNING);
	        }

	        if (trip.getTripStatus() == TripStatus.RUNNING &&
	            !now.isBefore(trip.getArrivalDateTime())) {

	            trip.setTripStatus(TripStatus.COMPLETED);
	        }
	    }

	    tripRepository.saveAll(trips);
	}

}