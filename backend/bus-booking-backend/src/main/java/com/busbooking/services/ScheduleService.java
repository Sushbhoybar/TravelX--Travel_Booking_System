package com.busbooking.services;

import java.util.List;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.CreateScheduleRequest;
import com.busbooking.dtos.ScheduleResponse;

public interface ScheduleService {

    ApiResponse addSchedule(CreateScheduleRequest request);

    List<ScheduleResponse> getAllSchedules();

    ScheduleResponse getScheduleById(Long scheduleId);

    ApiResponse deleteSchedule(Long scheduleId);

}