//package com.busbooking.servicesImpl;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.busbooking.custom_exception.ResourceNotFoundException;
//import com.busbooking.dtos.ApiResponse;
//import com.busbooking.dtos.CreateScheduleRequest;
//import com.busbooking.dtos.ScheduleResponse;
//import com.busbooking.entities.Bus;
//import com.busbooking.entities.Route;
//import com.busbooking.entities.Schedule;
//import com.busbooking.repository.BusRepository;
//import com.busbooking.repository.RouteRepository;
//import com.busbooking.repository.ScheduleRepository;
//import com.busbooking.services.ScheduleService;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class ScheduleServiceImpl implements ScheduleService {
//
//    private final ScheduleRepository scheduleRepository;
//    private final BusRepository busRepository;
//    private final RouteRepository routeRepository;
//
//    @Override
//    public ApiResponse addSchedule(CreateScheduleRequest request) {
//
//        Bus bus = busRepository.findById(request.getBusId())
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("Bus Not Found"));
//
//        Route route = routeRepository.findById(request.getRouteId())
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("Route Not Found"));
//
//        Schedule schedule = new Schedule();
//
//        schedule.setBus(bus);
//
//        schedule.setRoute(route);
//
//        schedule.setJourneyDate(request.getJourneyDate());
//
//        schedule.setDepartureTime(request.getDepartureTime());
//
//        schedule.setArrivalTime(request.getArrivalTime());
//
//        schedule.setFare(request.getFare());
//
//        schedule.setAvailableSeats(request.getAvailableSeats());
//
//        scheduleRepository.save(schedule);
//
//        return new ApiResponse("Schedule Added Successfully");
//
//    }
//
//    @Override
//    public List<ScheduleResponse> getAllSchedules() {
//
//        return scheduleRepository.findAll()
//
//                .stream()
//
//                .map(schedule -> {
//
//                    ScheduleResponse response =
//                            new ScheduleResponse();
//
//                    response.setScheduleId(schedule.getScheduleId());
//
//                    response.setBusId(schedule.getBus().getBusId());
//
//                    response.setBusName(schedule.getBus().getBusName());
//
//                    response.setRouteId(schedule.getRoute().getRouteId());
//
//                    response.setSource(schedule.getRoute().getSource());
//
//                    response.setDestination(schedule.getRoute().getDestination());
//
//                    response.setJourneyDate(schedule.getJourneyDate());
//
//                    response.setDepartureTime(schedule.getDepartureTime());
//
//                    response.setArrivalTime(schedule.getArrivalTime());
//
//                    response.setFare(schedule.getFare());
//
//                    response.setAvailableSeats(schedule.getAvailableSeats());
//
//                    response.setStatus(schedule.getStatus().name());
//
//                    return response;
//
//                })
//
//                .collect(Collectors.toList());
//
//    }
//
//    @Override
//    public ScheduleResponse getScheduleById(Long scheduleId) {
//
//        Schedule schedule = scheduleRepository.findById(scheduleId)
//
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("Schedule Not Found"));
//
//        ScheduleResponse response = new ScheduleResponse();
//
//        response.setScheduleId(schedule.getScheduleId());
//
//        response.setBusId(schedule.getBus().getBusId());
//
//        response.setBusName(schedule.getBus().getBusName());
//
//        response.setRouteId(schedule.getRoute().getRouteId());
//
//        response.setSource(schedule.getRoute().getSource());
//
//        response.setDestination(schedule.getRoute().getDestination());
//
//        response.setJourneyDate(schedule.getJourneyDate());
//
//        response.setDepartureTime(schedule.getDepartureTime());
//
//        response.setArrivalTime(schedule.getArrivalTime());
//
//        response.setFare(schedule.getFare());
//
//        response.setAvailableSeats(schedule.getAvailableSeats());
//
//        response.setStatus(schedule.getStatus().name());
//
//        return response;
//
//    }
//
//    @Override
//    public ApiResponse deleteSchedule(Long scheduleId) {
//
//        Schedule schedule = scheduleRepository.findById(scheduleId)
//
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("Schedule Not Found"));
//
//        scheduleRepository.delete(schedule);
//
//        return new ApiResponse("Schedule Deleted Successfully");
//
//    }
//
//}