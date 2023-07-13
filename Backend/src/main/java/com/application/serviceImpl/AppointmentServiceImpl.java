package com.application.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.exception.AppointmentAlreadyBookedException;
import com.application.exception.ResourceNotFoundException;
import com.application.model.Appointment;
import com.application.repository.AppointmentRepository;
import com.application.service.AppointmentService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
    private AppointmentRepository appointmentRepository;

    
    

    @Override
    public Appointment createAppointment(Appointment appointment) {
    	 List<Appointment> appointments = appointmentRepository.findByDoctorIdAndDateAndTime(
    	            appointment.getDoctor().getId(), appointment.getDate(), appointment.getTime());
    	    if (!appointments.isEmpty()) {
    	        throw new AppointmentAlreadyBookedException("Appointment slot already taken for doctor with id " 
    	                + appointment.getDoctor() + " at " + appointment.getDate() + " " + appointment.getTime());
    	    }

    	    // If appointment slot is not taken, book the appointment
    	    return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public void cancelAppointment(Long id) {
        Appointment appointment = getAppointmentById(id);
        appointment.setCancelled(true);
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorIdAndDate(Long doctorId, LocalDate date) {
        return appointmentRepository.findByDoctorIdAndDate(doctorId, date);
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorIdAndDateRange(Long doctorId, LocalDate startDate, LocalDate endDate) {
        return appointmentRepository.findByDoctorIdAndDateBetween(doctorId, startDate, endDate);
    }

	@Override
	public List<Appointment> getAppointmentByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return appointmentRepository.findByDate(date);
	}
}
