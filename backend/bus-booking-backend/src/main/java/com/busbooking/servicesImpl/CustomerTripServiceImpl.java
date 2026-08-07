package com.busbooking.servicesImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busbooking.custom_exception.BusinessException;
import com.busbooking.dtos.CustomerTripDetailsResponse;
import com.busbooking.dtos.CustomerTripResponse;
import com.busbooking.dtos.SearchTripRequest;
import com.busbooking.dtos.SeatLayoutResponse;
import com.busbooking.dtos.TripSeatLayoutResponse;
import com.busbooking.entities.BusImage;
import com.busbooking.entities.BusStatus;
import com.busbooking.entities.Trip;
import com.busbooking.entities.TripSeat;
import com.busbooking.entities.TripStatus;
import com.busbooking.repository.TripRepository;
import com.busbooking.repository.TripSeatRepository;
import com.busbooking.services.CustomerTripService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerTripServiceImpl implements CustomerTripService {
    
    private final TripSeatRepository tripSeatRepository;

    private final TripRepository tripRepository;

    @Override
    public List<CustomerTripResponse> searchTrips(
            SearchTripRequest request) {

        LocalDateTime startDateTime =
                request.getJourneyDate().atStartOfDay();

        LocalDateTime endDateTime =
                request.getJourneyDate().atTime(23, 59, 59);

        List<Trip> trips = tripRepository.searchTrips(
                request.getSourceCity(),
                request.getDestinationCity(),
                startDateTime,
                endDateTime,
                TripStatus.SCHEDULED,
                BusStatus.APPROVED);

        return trips.stream()
                .map(this::mapToCustomerTripResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerTripDetailsResponse getTripDetails(
            Long tripId) {

        Trip trip = tripRepository
                .findCustomerTripById(
                        tripId,
                        TripStatus.SCHEDULED,
                        BusStatus.APPROVED)
                .orElseThrow(() ->
                        new BusinessException("Trip not found."));

        return mapToCustomerTripDetailsResponse(trip);
    }

    // ======================================================
    // Mapper
    // ======================================================

    private CustomerTripResponse mapToCustomerTripResponse(
            Trip trip) {

        CustomerTripResponse response =
                new CustomerTripResponse();

        response.setTripId(trip.getTripId());

        response.setBusId(trip.getBus().getBusId());

        response.setBusName(trip.getBus().getBusName());

        response.setRegistrationNumber(
                trip.getBus().getRegistrationNumber());

        response.setBusType(
                trip.getBus().getBusType());

        response.setSourceCity(
                trip.getRoute().getSourceCity());

        response.setDestinationCity(
                trip.getRoute().getDestinationCity());

        response.setDepartureDateTime(
                trip.getDepartureDateTime());

        response.setArrivalDateTime(
                trip.getArrivalDateTime());

        response.setFare(
                trip.getBaseFare());

        response.setAvailableSeats(
                trip.getAvailableSeats());

        response.setAverageRating(0.0);

        response.setDurationMinutes(
                Duration.between(
                        trip.getDepartureDateTime(),
                        trip.getArrivalDateTime())
                        .toMinutes());

        return response;
    }

    private CustomerTripDetailsResponse
            mapToCustomerTripDetailsResponse(
                    Trip trip) {

        CustomerTripDetailsResponse response =
                new CustomerTripDetailsResponse();

        response.setTripId(trip.getTripId());

        response.setBusId(
                trip.getBus().getBusId());

        response.setBusName(
                trip.getBus().getBusName());

        response.setRegistrationNumber(
                trip.getBus().getRegistrationNumber());

        response.setBusType(
                trip.getBus().getBusType());

        response.setSourceCity(
                trip.getRoute().getSourceCity());

        response.setDestinationCity(
                trip.getRoute().getDestinationCity());

        response.setDepartureDateTime(
                trip.getDepartureDateTime());

        response.setArrivalDateTime(
                trip.getArrivalDateTime());

        response.setFare(
                trip.getBaseFare());

        response.setTotalSeats(
                trip.getBus().getTotalSeats());

        response.setAvailableSeats(
                trip.getAvailableSeats());

        response.setAmenities(
                trip.getBus().getAmenities());

        response.setBusImages(
                trip.getBus()
                        .getImages()
                        .stream()
                        .map(BusImage::getImageUrl)
                        .collect(Collectors.toList()));

        response.setAverageRating(0.0);

        response.setDurationMinutes(
                Duration.between(
                        trip.getDepartureDateTime(),
                        trip.getArrivalDateTime())
                        .toMinutes());

        return response;
    }

    @Override
	@Transactional(readOnly = true)
	public TripSeatLayoutResponse getTripSeatLayout(Long tripId) {

	    Trip trip = tripRepository.findById(tripId)
	            .orElseThrow(() ->
	                    new BusinessException("Trip not found"));

	    if (trip.getTripStatus() != TripStatus.SCHEDULED &&
	        trip.getTripStatus() != TripStatus.RUNNING) {

	        throw new BusinessException(
	                "Seat layout is not available for this trip.");
	    }

	    List<TripSeat> tripSeats =
	            tripSeatRepository
	                    .findByTripTripIdOrderBySeatDeckAscSeatRowNoAscSeatColumnNoAsc(
	                            tripId);

	    TripSeatLayoutResponse response =
	            new TripSeatLayoutResponse();

	    response.setTripId(
	            trip.getTripId());

	    response.setBusName(
	            trip.getBus().getBusName());

	    response.setBusType(
	            trip.getBus().getBusType());

	    response.setFare(
	            trip.getBaseFare());

	    response.setTotalSeats(
	            trip.getBus().getTotalSeats());

	    response.setAvailableSeats(
	            trip.getAvailableSeats());

	    List<SeatLayoutResponse> seats =
	            new ArrayList<>();

	    for (TripSeat tripSeat : tripSeats) {

	        SeatLayoutResponse dto =
	                new SeatLayoutResponse();

	        dto.setTripSeatId(
	                tripSeat.getTripSeatId());

	        dto.setSeatId(
	                tripSeat.getSeat().getSeatId());

	        dto.setSeatNumber(
	                tripSeat.getSeat().getSeatNumber());

	        dto.setRowNo(
	                tripSeat.getSeat().getRowNo());

	        dto.setColumnNo(
	                tripSeat.getSeat().getColumnNo());

	        dto.setDeck(
	                tripSeat.getSeat().getDeck());

	        dto.setSeatCategory(
	                tripSeat.getSeat().getSeatCategory());

	        dto.setSeatPosition(
	                tripSeat.getSeat().getSeatPosition());

	        dto.setBooked(
	                tripSeat.getBooked());

	        dto.setLocked(
	                tripSeat.getLocked());

	        seats.add(dto);

	    }

	    response.setSeats(seats);

	    return response;

	}

}