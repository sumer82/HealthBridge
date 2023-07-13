package com.application.service;

import java.util.List;

import com.application.model.Schedule;

public interface ScheduleService {
    Schedule createSchedule(Schedule schedule);
    Schedule getScheduleById(Long id);
    List<Schedule> getAllSchedules();
    List<Schedule> getSchedulesByDoctorId(Long doctorId);
    void deleteSchedule(Long id);
	Schedule addSchedule(Schedule schedule);
	
	Schedule updateSchedule(Long scheduleId, Schedule updatedSchedule);
}
