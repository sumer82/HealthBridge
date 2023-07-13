package com.application.service;

import java.time.LocalDate;
import java.util.List;

import com.application.model.Appointment;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    Appointment getAppointmentById(Long id);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByDoctorId(Long doctorId);
    List<Appointment> getAppointmentsByPatientId(Long patientId);
    void cancelAppointment(Long id);
	List<Appointment> getAppointmentsByDoctorIdAndDate(Long doctorId, LocalDate date);
	List<Appointment> getAppointmentsByDoctorIdAndDateRange(Long doctorId, LocalDate startDate, LocalDate endDate);
	List<Appointment> getAppointmentByDate(LocalDate date);
	
}
