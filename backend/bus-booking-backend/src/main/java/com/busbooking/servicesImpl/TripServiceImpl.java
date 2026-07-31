//package com.busbooking.servicesImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.busbooking.custom_exception.ResourceNotFoundException;
//import com.busbooking.dtos.ApiResponse;
//import com.busbooking.dtos.TripDetailsResponse;
//import com.busbooking.dtos.TripRequest;
//import com.busbooking.dtos.TripResponse;
//import com.busbooking.entities.Bus;
//import com.busbooking.entities.BusStatus;
//import com.busbooking.entities.Route;
//import com.busbooking.entities.Trip;
//import com.busbooking.entities.TripStatus;
//import com.busbooking.entities.User;
//import com.busbooking.repository.BusRepository;
//import com.busbooking.repository.RouteRepository;
//import com.busbooking.repository.TripRepository;
//import com.busbooking.repository.UserRepository;
//import com.busbooking.services.TripService;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class TripServiceImpl implements TripService {
//
//    private static final Logger logger =
//            LoggerFactory.getLogger(TripServiceImpl.class);
//
//    private final TripRepository tripRepository;
//
//    private final BusRepository busRepository;
//
//    private final RouteRepository routeRepository;
//
//    private final UserRepository userRepository;
//
//    @Override
//    public ApiResponse createTrip(
//            TripRequest request,
//            String email) {
//
//        logger.info("Creating trip for agent {}", email);
//
//        User agent =
//                userRepository.findByEmail(email)
//                        .orElseThrow(() ->
//                                new ResourceNotFoundException(
//                                        "Agent not found"));
//
//        Bus bus =
//                busRepository.findByBusIdAndAgent(
//                                request.getBusId(),
//                                agent)
//                        .orElseThrow(() ->
//                                new ResourceNotFoundException(
//                                        "Bus not found"));
//
//        if (bus.getStatus() != BusStatus.APPROVED) {
//
//            throw new IllegalStateException(
//                    "Bus is not approved by Admin");
//
//        }
//
//        Route route =
//                routeRepository.findById(
//                                request.getRouteId())
//                        .orElseThrow(() ->
//                                new ResourceNotFoundException(
//                                        "Route not found"));
//
//        if (request.getArrivalDateTime()
//                .isBefore(
//                        request.getDepartureDateTime())) {
//
//            throw new IllegalArgumentException(
//                    "Arrival time must be after departure");
//
//        }
//
//        Trip trip = new Trip();
//
//        trip.setBus(bus);
//
//        trip.setRoute(route);
//
//        trip.setBoardingPoint(
//                request.getBoardingPoint());
//
//        trip.setDroppingPoint(
//                request.getDroppingPoint());
//
//        trip.setDepartureDateTime(
//                request.getDepartureDateTime());
//
//        trip.setArrivalDateTime(
//                request.getArrivalDateTime());
//
//        trip.setFare(
//                request.getFare());
//
//        if (request.getStatus() == null) {
//
//            trip.setStatus(
//                    TripStatus.SCHEDULED);
//
//        } else {
//
//            trip.setStatus(
//                    request.getStatus());
//
//        }
//
//        tripRepository.save(trip);
//
//        logger.info(
//                "Trip {} created successfully",
//                trip.getTripId());
//
//        return new ApiResponse(
//                "Trip Created Successfully");
//
//    }
//    @Override
//    @Transactional(readOnly = true)
//    public List<TripResponse> getMyTrips(String email) {
//
//        logger.info("Fetching trips for agent {}", email);
//
//        User agent = userRepository.findByEmail(email)
//                .orElseThrow(() ->
//                        new ResourceNotFoundException(
//                                "Agent not found"));
//
//        List<Bus> buses = busRepository.findByAgent(agent);
//
//        List<TripResponse> response = new ArrayList<>();
//
//        for (Bus bus : buses) {
//
//            List<Trip> trips = tripRepository.findByBus(bus);
//
//            for (Trip trip : trips) {
//
//                TripResponse dto = new TripResponse();
//
//                dto.setTripId(
//                        trip.getTripId());
//
//                dto.setBusId(
//                        bus.getBusId());
//
//                dto.setBusName(
//                        bus.getBusName());
//
//                dto.setRouteId(
//                        trip.getRoute().getRouteId());
//
//                dto.setSource(
//                        trip.getRoute().getSourceCity());
//
//                dto.setDestination(
//                        trip.getRoute().getDestinationCity());
//
//                dto.setBoardingPoint(
//                        trip.getBoardingPoint());
//
//                dto.setDroppingPoint(
//                        trip.getDroppingPoint());
//
//                dto.setDepartureDateTime(
//                        trip.getDepartureDateTime());
//
//                dto.setArrivalDateTime(
//                        trip.getArrivalDateTime());
//
//                dto.setFare(
//                        trip.getFare());
//
//                dto.setStatus(
//                        trip.getStatus());
//
//                response.add(dto);
//
//            }
//
//        }
//
//        logger.info("{} trips found",
//                response.size());
//
//        return response;
//
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public TripDetailsResponse getTrip(Long tripId) {
//
//        logger.info("Fetching trip {}", tripId);
//
//        Trip trip = tripRepository.findById(tripId)
//                .orElseThrow(() ->
//                        new ResourceNotFoundException(
//                                "Trip not found"));
//
//        TripDetailsResponse dto =
//                new TripDetailsResponse();
//
//        dto.setTripId(
//                trip.getTripId());
//
//        dto.setBusId(
//                trip.getBus().getBusId());
//
//        dto.setBusName(
//                trip.getBus().getBusName());
//
//        dto.setBusType(
//                trip.getBus().getBusType());
//
//        dto.setTotalSeats(
//                trip.getBus().getTotalSeats());
//
//        dto.setRouteId(
//                trip.getRoute().getRouteId());
//
//        dto.setSource(
//                trip.getRoute().getSourceCity());
//
//        dto.setDestination(
//                trip.getRoute().getDestinationCity());
//
//        dto.setBoardingPoint(
//                trip.getBoardingPoint());
//
//        dto.setDroppingPoint(
//                trip.getDroppingPoint());
//
//        dto.setDepartureDateTime(
//                trip.getDepartureDateTime());
//
//        dto.setArrivalDateTime(
//                trip.getArrivalDateTime());
//
//        dto.setFare(
//                trip.getFare());
//
//        dto.setStatus(
//                trip.getStatus());
//
//        return dto;
//
//    }
//    @Override
//    public ApiResponse updateTrip(
//            Long tripId,
//            TripRequest request) {
//
//        logger.info("Updating trip {}", tripId);
//
//        Trip trip = tripRepository.findById(tripId)
//                .orElseThrow(() ->
//                        new ResourceNotFoundException(
//                                "Trip not found"));
//
//        Bus bus = busRepository.findById(
//                request.getBusId())
//                .orElseThrow(() ->
//                        new ResourceNotFoundException(
//                                "Bus not found"));
//
//        Route route = routeRepository.findById(
//                request.getRouteId())
//                .orElseThrow(() ->
//                        new ResourceNotFoundException(
//                                "Route not found"));
//
//        if (request.getArrivalDateTime()
//                .isBefore(request.getDepartureDateTime())) {
//
//            throw new IllegalArgumentException(
//                    "Arrival time must be after departure");
//        }
//
//        trip.setBus(bus);
//
//        trip.setRoute(route);
//
//        trip.setBoardingPoint(
//                request.getBoardingPoint());
//
//        trip.setDroppingPoint(
//                request.getDroppingPoint());
//
//        trip.setDepartureDateTime(
//                request.getDepartureDateTime());
//
//        trip.setArrivalDateTime(
//                request.getArrivalDateTime());
//
//        trip.setFare(
//                request.getFare());
//
//        trip.setStatus(
//                request.getStatus());
//
//        tripRepository.save(trip);
//
//        logger.info(
//                "Trip {} updated successfully",
//                tripId);
//
//        return new ApiResponse(
//                "Trip Updated Successfully");
//
//    }
//    @Override
//    public ApiResponse deleteTrip(Long tripId) {
//
//        logger.info("Deleting trip {}", tripId);
//
//        Trip trip = tripRepository.findById(tripId)
//                .orElseThrow(() ->
//                        new ResourceNotFoundException(
//                                "Trip not found"));
//
//        tripRepository.delete(trip);
//
//        logger.info(
//                "Trip {} deleted successfully",
//                tripId);
//
//        return new ApiResponse(
//                "Trip Deleted Successfully");
//
//    }
//}